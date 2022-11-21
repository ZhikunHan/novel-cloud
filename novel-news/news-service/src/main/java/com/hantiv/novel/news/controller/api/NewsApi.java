package com.hantiv.novel.news.controller.api;

import com.hantiv.novel.news.entity.News;
import com.hantiv.novel.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 新闻微服务API接口（内部调用）
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@RestController
@RequestMapping(("api/news"))
@ApiIgnore
@RequiredArgsConstructor
public class NewsApi {

    private final NewsService newsService;

    /**
     * 查询最新新闻集合
     * @param limit 查询条数
     * @return 新闻集合
     * */
    @GetMapping("listLastIndexNews")
    List<News> listLastIndexNews(@RequestParam("limit") int limit){

        return newsService.listLastIndexNews(limit);

    }



}
