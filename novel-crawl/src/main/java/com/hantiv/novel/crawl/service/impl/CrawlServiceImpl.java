package com.hantiv.novel.crawl.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.hantiv.novel.book.entity.Book;
import com.hantiv.novel.common.bean.PageBean;
import com.hantiv.novel.common.cache.CacheKey;
import com.hantiv.novel.common.cache.CacheService;
import com.hantiv.novel.crawl.core.crawl.CrawlParser;
import com.hantiv.novel.crawl.core.crawl.RuleBean;
import com.hantiv.novel.common.enums.ResponseStatus;
import com.hantiv.novel.common.bean.PageBuilder;
import com.hantiv.novel.common.utils.IdWorker;
import com.hantiv.novel.common.utils.ThreadUtil;
import com.hantiv.novel.common.exception.BusinessException;
import com.hantiv.novel.common.utils.BeanUtil;
import com.hantiv.novel.crawl.entity.CrawlSingleTask;
import com.hantiv.novel.crawl.entity.CrawlSource;
import com.hantiv.novel.crawl.mapper.CrawlSingleTaskDynamicSqlSupport;
import com.hantiv.novel.crawl.mapper.CrawlSingleTaskMapper;
import com.hantiv.novel.crawl.mapper.CrawlSourceDynamicSqlSupport;
import com.hantiv.novel.crawl.mapper.CrawlSourceMapper;
import com.hantiv.novel.crawl.service.CrawlService;
import com.hantiv.novel.crawl.vo.CrawlSingleTaskVO;
import com.hantiv.novel.crawl.vo.CrawlSourceVO;
import com.hantiv.novel.common.utils.SpringUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.hantiv.novel.crawl.mapper.CrawlSourceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

import static com.hantiv.novel.common.utils.HttpUtil.getByHttpClientWithChrome;

/**
 * @Author Zhikun Han
 * @Date Created in 16:57 2022/11/20
 * @Description:
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CrawlServiceImpl implements CrawlService {
    private final CrawlSourceMapper crawlSourceMapper;

    private final CrawlSingleTaskMapper crawlSingleTaskMapper;

    private final BookService bookService;

    private final CacheService cacheService;

    private final IdWorker idWorker = new IdWorker();


    @Override
    public void addCrawlSource(CrawlSource source) {
        Date currentDate = new Date();
        source.setCreateTime(currentDate);
        source.setUpdateTime(currentDate);
        crawlSourceMapper.insert(source);

    }

    @Override
    public void updateCrawlSource(CrawlSource source) {
        if (source.getId() != null) {
            CrawlSource crawlSource = crawlSourceMapper.selectById(source.getId());
            if (crawlSource.getSourceStatus() == (byte) 1) {
                //??????
                openOrCloseCrawl(crawlSource.getId(), (byte) 0);
            }
            Date currentDate = new Date();
            crawlSource.setUpdateTime(currentDate);
            crawlSource.setCrawlRule(source.getCrawlRule());
            crawlSource.setSourceName(source.getSourceName());
            crawlSourceMapper.updateByPrimaryKey(crawlSource);

        }
    }

    @Override
    public PageBean<CrawlSource> listCrawlByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        SelectStatementProvider render = select(id, sourceName, sourceStatus, createTime, updateTime)
                .from(crawlSource)
                .orderBy(updateTime)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<CrawlSource> crawlSources = crawlSourceMapper.selectMany(render);
        PageBean<CrawlSource> pageBean = PageBuilder.build(crawlSources);
        pageBean.setList(BeanUtil.copyList(crawlSources, CrawlSourceVO.class));
        return pageBean;
    }

    @SneakyThrows
    @Override
    public void openOrCloseCrawl(Integer sourceId, Byte sourceStatus) {

        //????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        //?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        // ?????????????????????????????????????????????????????????????????????????????????runningCrawlThread???
        if (sourceStatus == (byte) 0) {
            //??????,?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
            SpringUtil.getBean(CrawlService.class).updateCrawlSourceStatus(sourceId, sourceStatus);
            Set<Long> runningCrawlThreadId = (Set<Long>) cacheService.getObject(CacheKey.RUNNING_CRAWL_THREAD_KEY_PREFIX + sourceId);
            if (runningCrawlThreadId != null) {
                for (Long ThreadId : runningCrawlThreadId) {
                    Thread thread = ThreadUtil.findThread(ThreadId);
                    if (thread != null && thread.isAlive()) {
                        thread.interrupt();
                    }
                }
            }


        } else {
            //??????
            //??????????????????????????????
            CrawlSource source = queryCrawlSource(sourceId);
            Byte realSourceStatus = source.getSourceStatus();

            if (realSourceStatus == (byte) 0) {
                //?????????????????????????????????,??????????????????????????????????????????????????????????????????runningCrawlThread???
                SpringUtil.getBean(CrawlService.class).updateCrawlSourceStatus(sourceId, sourceStatus);
                RuleBean ruleBean = new ObjectMapper().readValue(source.getCrawlRule(), RuleBean.class);

                Set<Long> threadIds = new HashSet<>();
                //?????????????????????????????????
                for (int i = 1; i < 8; i++) {
                    final int catId = i;
                    Thread thread = new Thread(() -> CrawlServiceImpl.this.parseBookList(catId, ruleBean, sourceId));
                    thread.start();
                    //thread????????????????????????
                    threadIds.add(thread.getId());

                }
                cacheService.setObject(CacheKey.RUNNING_CRAWL_THREAD_KEY_PREFIX + sourceId, threadIds);


            }


        }

    }

    @Override
    public CrawlSource queryCrawlSource(Integer sourceId) {
        SelectStatementProvider render = select(CrawlSourceDynamicSqlSupport.sourceStatus, CrawlSourceDynamicSqlSupport.crawlRule)
                .from(crawlSource)
                .where(id, isEqualTo(sourceId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return crawlSourceMapper.selectMany(render).get(0);
    }

    @Override
    public void addCrawlSingleTask(CrawlSingleTask singleTask) {

        if (bookService.queryIsExistByBookNameAndAuthorName(singleTask.getBookName(), singleTask.getAuthorName())) {
            throw new BusinessException(ResponseStatus.BOOK_EXISTS);

        }
        singleTask.setCreateTime(new Date());
        crawlSingleTaskMapper.insertSelective(singleTask);


    }

    @Override
    public PageBean<CrawlSingleTask> listCrawlSingleTaskByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        SelectStatementProvider render = select(CrawlSingleTaskDynamicSqlSupport.crawlSingleTask.allColumns())
                .from(CrawlSingleTaskDynamicSqlSupport.crawlSingleTask)
                .orderBy(CrawlSingleTaskDynamicSqlSupport.createTime.descending())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<CrawlSingleTask> crawlSingleTasks = crawlSingleTaskMapper.selectMany(render);
        PageBean<CrawlSingleTask> pageBean = PageBuilder.build(crawlSingleTasks);
        pageBean.setList(BeanUtil.copyList(crawlSingleTasks, CrawlSingleTaskVO.class));
        return pageBean;
    }

    @Override
    public void delCrawlSingleTask(Long id) {
        crawlSingleTaskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CrawlSingleTask getCrawlSingleTask() {

        List<CrawlSingleTask> list = crawlSingleTaskMapper.selectMany(select(CrawlSingleTaskDynamicSqlSupport.crawlSingleTask.allColumns())
                .from(CrawlSingleTaskDynamicSqlSupport.crawlSingleTask)
                .where(CrawlSingleTaskDynamicSqlSupport.taskStatus, isEqualTo((byte) 2))
                .orderBy(CrawlSingleTaskDynamicSqlSupport.createTime)
                .limit(1)
                .build()
                .render(RenderingStrategies.MYBATIS3));

        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public void updateCrawlSingleTask(CrawlSingleTask task, Byte status) {
        byte excCount = task.getExcCount();
        excCount += 1;
        task.setExcCount(excCount);
        if (status == 1 || excCount == 5) {
            //???????????????????????????????????????5????????????????????????????????????????????????
            task.setTaskStatus(status);
        }
        crawlSingleTaskMapper.updateByPrimaryKeySelective(task);

    }

    @Override
    public CrawlSource getCrawlSource(Integer id) {
        Optional<CrawlSource> opt=crawlSourceMapper.selectByPrimaryKey(id);
        if(opt.isPresent()) {
            CrawlSource crawlSource =opt.get();
            return crawlSource;
        }
        return null;
    }

    /**
     * ??????????????????
     */
    @Override
    public void parseBookList(int catId, RuleBean ruleBean, Integer sourceId) {

        //????????????1
        int page = 1;
        int totalPage = page;

        while (page <= totalPage) {

            try {

                if (StringUtils.isNotBlank(ruleBean.getCatIdRule().get("catId" + catId))) {
                    //????????????URL
                    String catBookListUrl = ruleBean.getBookListUrl()
                            .replace("{catId}", ruleBean.getCatIdRule().get("catId" + catId))
                            .replace("{page}", page + "");

                    String bookListHtml = getByHttpClientWithChrome(catBookListUrl);
                    if (bookListHtml != null) {
                        Pattern bookIdPatten = Pattern.compile(ruleBean.getBookIdPatten());
                        Matcher bookIdMatcher = bookIdPatten.matcher(bookListHtml);
                        boolean isFindBookId = bookIdMatcher.find();
                        while (isFindBookId) {
                            try {
                                //1.???????????????????????? sleep,???????????? wait,socket ?????? receiver,accept ???????????????
                                //??????????????????InterruptedException??????????????????
                                //2.????????????????????????????????????????????????????????????
                                if (Thread.currentThread().isInterrupted()) {
                                    return;
                                }
                                String bookId = bookIdMatcher.group(1);
                                parseBookAndSave(catId, ruleBean, sourceId, bookId);
                            } catch (Exception e) {
                                log.error(e.getMessage(), e);
                            }


                            isFindBookId = bookIdMatcher.find();
                        }

                        Pattern totalPagePatten = Pattern.compile(ruleBean.getTotalPagePatten());
                        Matcher totalPageMatcher = totalPagePatten.matcher(bookListHtml);
                        boolean isFindTotalPage = totalPageMatcher.find();
                        if (isFindTotalPage) {

                            totalPage = Integer.parseInt(totalPageMatcher.group(1));

                        }


                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            page += 1;
        }


    }

    @Override
    public boolean parseBookAndSave(int catId, RuleBean ruleBean, Integer sourceId, String bookId) {

        final AtomicBoolean parseResult = new AtomicBoolean(false);

        CrawlParser.parseBook(ruleBean, bookId, book -> {
            if (book.getBookName() == null || book.getAuthorName() == null) {
                return;
            }
            //??????????????????????????????????????????????????????
            Book existBook = bookService.queryBookByBookNameAndAuthorName(book.getBookName(), book.getAuthorName());
            //???????????????????????????????????????????????????????????????????????????????????????30?????????????????????????????????
            if (existBook == null) {
                //???????????????????????????
                book.setCatId(catId);
                //????????????ID????????????
                book.setCatName(bookService.queryCatNameByCatId(catId));
                if (catId == 7) {
                    //??????
                    book.setWorkDirection((byte) 1);
                } else {
                    //??????
                    book.setWorkDirection((byte) 0);
                }
                book.setCrawlBookId(bookId);
                book.setCrawlSourceId(sourceId);
                book.setCrawlLastTime(new Date());
                book.setId(idWorker.nextId());
                //??????????????????
                boolean parseIndexContentResult = CrawlParser.parseBookIndexAndContent(bookId, book, ruleBean, new HashMap<>(0), chapter -> {
                    bookService.saveBookAndIndexAndContent(book, chapter.getBookIndexList(), chapter.getBookContentList());
                });
                parseResult.set(parseIndexContentResult);

            } else {
                //????????????????????????????????????
                bookService.updateCrawlProperties(existBook.getId(), sourceId, bookId);
                parseResult.set(true);
            }
        });

        return parseResult.get();

    }

    @Override
    public void updateCrawlSourceStatus(Integer sourceId, Byte sourceStatus) {
        CrawlSource source = new CrawlSource();
        source.setId(sourceId);
        source.setSourceStatus(sourceStatus);
        crawlSourceMapper.updateByPrimaryKeySelective(source);
    }

    @Override
    public List<CrawlSource> queryCrawlSourceByStatus(Byte sourceStatus) {
        SelectStatementProvider render = select(CrawlSourceDynamicSqlSupport.id, CrawlSourceDynamicSqlSupport.sourceStatus, CrawlSourceDynamicSqlSupport.crawlRule)
                .from(crawlSource)
                .where(CrawlSourceDynamicSqlSupport.sourceStatus, isEqualTo(sourceStatus))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return crawlSourceMapper.selectMany(render);
    }
}
