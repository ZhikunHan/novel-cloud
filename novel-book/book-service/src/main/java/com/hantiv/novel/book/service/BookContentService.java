package com.hantiv.novel.book.service;

import com.hantiv.novel.book.entity.BookContent;

import java.util.List;

/**
 * @Author Zhikun Han
 * @Date Created in 15:56 2022/11/27
 * @Description:
 */
public interface BookContentService {
    void saveBookContent(List<BookContent> bookContentList, Long bookId);

    void saveBookContent(BookContent bookContent,Long bookId);

    void updateBookContent(BookContent bookContent,Long bookId);
}
