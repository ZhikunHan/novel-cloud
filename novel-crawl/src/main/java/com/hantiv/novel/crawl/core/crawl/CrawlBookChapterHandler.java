package com.hantiv.novel.crawl.core.crawl;

/**
 * @Author Zhikun Han
 * @Date Created in 20:31 2022/11/20
 * @Description: 爬虫小说章节内容处理器
 */
public interface CrawlBookChapterHandler {
    void handle(ChapterBean chapterBean);
}
