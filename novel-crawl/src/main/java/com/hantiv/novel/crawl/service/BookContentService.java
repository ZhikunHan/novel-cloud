package com.hantiv.novel.crawl.service;

import com.hantiv.novel.book.entity.BookContent;

import java.util.List;

/**
 * @Author Zhikun Han
 * @Date Created in 16:56 2022/11/20
 * @Description:
 */
public interface BookContentService {
    void saveBookContent(List<BookContent> bookContentList, Long bookId);

    void saveBookContent(BookContent bookContent,Long bookId);

    void updateBookContent(BookContent bookContent,Long bookId);
}
