package com.hantiv.novel.book.service.impl;

import com.hantiv.novel.book.entity.BookContent;
import com.hantiv.novel.book.service.BookContentService;
import com.hantiv.novel.crawl.service.BookContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zhikun Han
 * @Date Created in 19:17 2022/11/20
 * @Description:
 */
@Service(value = "txt")
@RequiredArgsConstructor
public class FileBookContentServiceImpl implements BookContentService {

    @Value("${content.save.path}")
    private String fileSavePath;

    @Override
    public void saveBookContent(List<BookContent> bookContentList, Long bookId) {
        bookContentList.forEach(bookContent -> saveBookContent(bookContent,bookId));

    }

    @Override
    public void saveBookContent(BookContent bookContent,Long bookId) {
        FileUtil.writeContentToFile(fileSavePath,"/"+bookId+"/"+bookContent.getIndexId()+".txt",bookContent.getContent());
    }

    @Override
    public void updateBookContent(BookContent bookContent,Long bookId) {
        FileUtil.writeContentToFile(fileSavePath,"/"+bookId+"/"+bookContent.getIndexId()+".txt",bookContent.getContent());
    }
}
