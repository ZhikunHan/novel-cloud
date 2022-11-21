package com.hantiv.novel.crawl.core.crawl;

import com.hantiv.novel.book.entity.BookContent;
import com.hantiv.novel.book.entity.BookIndex;
import lombok.Data;

import java.util.List;

/**
 * @Author Zhikun Han
 * @Date Created in 16:21 2022/11/20
 * @Description: 章节数据封装Bean
 */
@Data
public class ChapterBean {

    /**
     * 章节索引集合
     * */
    List<BookIndex> bookIndexList;

    /**
     * 章节内容集合
     * */
    List<BookContent> bookContentList;

}
