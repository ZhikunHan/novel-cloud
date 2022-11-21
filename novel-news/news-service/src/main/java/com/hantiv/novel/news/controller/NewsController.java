package com.hantiv.novel.news.controller;

import com.hantiv.novel.common.bean.PageBean;
import com.hantiv.novel.common.bean.ResultBean;
import com.hantiv.novel.news.entity.News;
import com.hantiv.novel.news.service.NewsService;
import com.hantiv.novel.news.vo.NewsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 新闻微服务Controller
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@RestController
@RequestMapping("news")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "新闻相关接口")
public class NewsController {

    private final NewsService newsService;


    /**
     * 分页查询新闻列表接口
     * */
    @ApiOperation("分页查询新闻列表接口")
    @GetMapping("listByPage")
    public ResultBean<PageBean<News>> listByPage(@ApiParam("当前页码") @RequestParam(value = "curr", defaultValue = "1") int page, @ApiParam("每页大小") @RequestParam(value = "limit", defaultValue = "5") int pageSize){
        return ResultBean.ok(newsService.listByPage(page,pageSize));
    }

    /**
     * 新闻内容查询接口
     * */
    @ApiOperation("新闻内容查询接口")
    @GetMapping("{newsId}")
    public ResultBean<NewsVO> newsInfo(@ApiParam("新闻ID") @PathVariable("newsId") Long newsId) {
        News news = newsService.queryNewsInfo(newsId);
        NewsVO newsVO = new NewsVO();
        BeanUtils.copyProperties(news,newsVO);
        return ResultBean.ok(newsVO);
    }




}
