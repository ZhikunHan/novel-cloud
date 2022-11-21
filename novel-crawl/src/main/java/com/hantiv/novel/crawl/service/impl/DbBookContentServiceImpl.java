package com.hantiv.novel.crawl.service.impl;

import com.hantiv.novel.book.entity.BookContent;
import com.hantiv.novel.book.mapper.BookContentMapper;
import com.hantiv.novel.crawl.service.BookContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zhikun Han
 * @Date Created in 19:15 2022/11/20
 * @Description:
 */
@Service(value = "db")
@RequiredArgsConstructor
public class DbBookContentServiceImpl implements BookContentService {

    private final BookContentMapper bookContentMapper;

    @Override
    public void saveBookContent(List<BookContent> bookContentList, Long bookId) {
        bookContentMapper.insertMultiple(bookContentList);
    }

    @Override
    public void saveBookContent(BookContent bookContent,Long bookId) {
        bookContentMapper.insertSelective(bookContent);
    }

    @Override
    public void updateBookContent(BookContent bookContent,Long bookId) {
        bookContentMapper.update(update(BookContentDynamicSqlSupport.bookContent)
                .set(BookContentDynamicSqlSupport.content)
                .equalTo(bookContent.getContent())
                .where(BookContentDynamicSqlSupport.indexId,isEqualTo(bookContent.getIndexId()))
                .build()
                .render(RenderingStrategies.MYBATIS3));
    }
}
