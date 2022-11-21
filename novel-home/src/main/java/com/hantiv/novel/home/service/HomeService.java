package com.hantiv.novel.home.service;


import com.hantiv.novel.book.entity.Book;
import com.hantiv.novel.book.vo.BookVO;
import com.hantiv.novel.home.entity.HomeFriendLink;
import com.hantiv.novel.home.vo.HomeBookVO;
import com.hantiv.novel.news.entity.News;

import java.util.List;

/**
 * 首页服务接口
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/28
 */
public interface HomeService {

    /**
     * 首页小说推荐数据查询
     * @return 首页推荐的小说数据
     * */
    List<HomeBookVO> listHomeBook();


    /**
     * 首页友情链接查询
     * @return 友情链接集合
     * */
    List<HomeFriendLink> listFriendLink();

    /**
     * 查询首页新闻
     * @return 新闻列表集合
     * */
    List<News> listIndexNews();

    /**
     * 首页点击榜单查询接口
     * @return 小说数据集合
     * */
    List<Book> listClickRank();

    /**
     * 首页新书榜单查询接口
     * @return 小说数据集合
     * */
    List<Book> listNewRank();

    /**
     * 首页更新榜单查询接口
     * @return 小说数据集合
     * */
    List<BookVO> listUpdateRank();
}
