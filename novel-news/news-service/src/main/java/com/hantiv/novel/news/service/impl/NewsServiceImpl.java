package com.hantiv.novel.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.hantiv.novel.common.bean.PageBean;
import com.hantiv.novel.common.utils.BeanUtil;
import com.hantiv.novel.news.entity.News;
import com.hantiv.novel.news.mapper.NewsDynamicSqlSupport;
import com.hantiv.novel.news.mapper.NewsMapper;
import com.hantiv.novel.news.service.NewsService;
import com.hantiv.novel.news.vo.NewsVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

/**
 * 新闻服务接口实现
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/28
 */
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsMapper newsMapper;



    @Override
    public PageBean<News> listByPage(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        SelectStatementProvider selectStatement =
                SelectDSL.select(NewsDynamicSqlSupport.id, NewsDynamicSqlSupport.catName,
                        NewsDynamicSqlSupport.catId, NewsDynamicSqlSupport.title,NewsDynamicSqlSupport.createTime)
                .from(NewsDynamicSqlSupport.news)
                .orderBy(NewsDynamicSqlSupport.createTime.descending())
                .build()
                .render(RenderingStrategies.MYBATIS3);

        List<News> news = newsMapper.selectMany(selectStatement);

        PageBean<News> pageBean = new PageBean<>(news);
        pageBean.setList(BeanUtil.copyList(newsMapper.selectMany(selectStatement), NewsVO.class));
        return pageBean;
    }

    @Override
    public List<News> listLastIndexNews(int limit) {
            SelectStatementProvider selectStatement =
                    select(NewsDynamicSqlSupport.id, NewsDynamicSqlSupport.catName,
                            NewsDynamicSqlSupport.catId, NewsDynamicSqlSupport.title)
                    .from(NewsDynamicSqlSupport.news)
                    .orderBy(NewsDynamicSqlSupport.createTime.descending())
                    .limit(limit)
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
            return newsMapper.selectMany(selectStatement);
    }

    @Override
    public News queryNewsInfo(Long newsId) {
        SelectStatementProvider selectStatement = select(NewsDynamicSqlSupport.news.allColumns())
                .from(NewsDynamicSqlSupport.news)
                .where(NewsDynamicSqlSupport.id,isEqualTo(newsId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return newsMapper.selectMany(selectStatement).get(0);
    }
}
