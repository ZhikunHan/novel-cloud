package com.hantiv.novel.news.service;


import com.hantiv.novel.common.bean.PageBean;
import com.hantiv.novel.news.entity.News;

import java.util.List;

/**
 * 新闻服务接口
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/28
 */
public interface NewsService {

    /**
     * 分页查询新闻列表接口
     * @param page 查询页码
     * @param pageSize 分页大小
     * @return 新闻列表集合
     * */
    PageBean<News> listByPage(int page, int pageSize);

    /**
     * 查询最新新闻集合
     * @param limit 查询条数
     * @return 新闻集合
     * */
    List<News> listLastIndexNews(int limit);

    /**
     * 查询新闻
     * @param newsId 新闻id
     * @return 新闻
     * */
    News queryNewsInfo(Long newsId);
}
