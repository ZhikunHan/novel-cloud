package com.hantiv.novel.crawl.core.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hantiv.novel.book.entity.Book;
import com.hantiv.novel.book.entity.BookIndex;
import com.hantiv.novel.crawl.core.crawl.RuleBean;
import com.hantiv.novel.crawl.entity.CrawlSource;
import com.hantiv.novel.crawl.service.CrawlService;
import com.hantiv.novel.crawl.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author Zhikun Han
 * @Date Created in 19:27 2022/11/20
 * @Description:
 */
@WebListener
@RequiredArgsConstructor
@Slf4j
public class StarterListener implements ServletContextListener {

    private final BookService bookService;

    private final CrawlService crawlService;

    @Value("${crawl.update.thread}")
    private int updateThreadCount;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        for (int i = 0; i < updateThreadCount; i++) {
            new Thread(() -> {
                log.info("程序启动,开始执行自动更新线程。。。");
                while (true){
                    try{
                        //1.查询最新目录更新时间在一个月之内的前100条需要更新的数据
                        Date currentDate = new Date();
                        Date startDate = DateUtils.addDays(currentDate, -30);
                        List<Book> bookList;
                        synchronized (this){
                            bookList = bookService.queryNeedUpdateBook(startDate, 100);
                        }
                        for (Book needUpdateBook : bookList) {
                            try {
                                //查询爬虫源规则
                                CrawlSource source = crawlService.queryCrawlSource(needUpdateBook.getCrawlSourceId());
                                RuleBean ruleBean = new ObjectMapper().readValue(source.getCrawlRule(), RuleBean.class);
                                //解析小说基本信息
                                CrawlParser.parseBook(ruleBean, needUpdateBook.getCrawlBookId(),book -> {
                                    //这里只做老书更新
                                    book.setId(needUpdateBook.getId());
                                    book.setWordCount(needUpdateBook.getWordCount());
                                    if (needUpdateBook.getPicUrl() != null && needUpdateBook.getPicUrl().contains(Constants.LOCAL_PIC_PREFIX)) {
                                        //本地图片则不更新
                                        book.setPicUrl(null);
                                    }
                                    //查询已存在的章节
                                    Map<Integer, BookIndex> existBookIndexMap = bookService.queryExistBookIndexMap(needUpdateBook.getId());
                                    //解析章节目录
                                    CrawlParser.parseBookIndexAndContent(needUpdateBook.getCrawlBookId(), book, ruleBean, existBookIndexMap,chapter -> {
                                        bookService.updateBookAndIndexAndContent(book, chapter.getBookIndexList(), chapter.getBookContentList(), existBookIndexMap);
                                    });
                                });
                            } catch (Exception e) {
                                log.error(e.getMessage(), e);
                            }
                        }
                        // 休眠10分钟
                        TimeUnit.MINUTES.sleep(10);
                    }catch (Exception e){
                        log.error(e.getMessage(), e);
                    }
                }
            }).start();
        }
    }

}
