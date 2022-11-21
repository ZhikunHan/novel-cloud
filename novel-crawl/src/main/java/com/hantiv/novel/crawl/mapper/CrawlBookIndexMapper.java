package com.hantiv.novel.crawl.mapper;

import com.hantiv.novel.book.entity.BookIndex;
import com.hantiv.novel.book.mapper.BookIndexMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Zhikun Han
 * @Date Created in 16:26 2022/11/20
 * @Description:
 */
public interface CrawlBookIndexMapper extends BookIndexMapper {

    /**
     * 查询最后的章节
     * */
    BookIndex queryLastIndex(@Param("bookId") Long bookId);

}
