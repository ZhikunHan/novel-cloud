package com.hantiv.novel.crawl.core.crawl;

import com.hantiv.novel.book.entity.Book;

/**
 * @Author Zhikun Han
 * @Date Created in 20:32 2022/11/20
 * @Description: 爬虫小说处理器
 */
public interface CrawlBookHandler {
    void handle(Book book);
}
