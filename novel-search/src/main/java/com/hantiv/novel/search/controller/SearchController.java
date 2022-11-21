package com.hantiv.novel.search.controller;

import com.hantiv.novel.common.bean.PageBean;
import com.hantiv.novel.common.bean.ResultBean;
import com.hantiv.novel.search.service.SearchService;
import com.hantiv.novel.search.vo.EsBookVO;
import com.hantiv.novel.search.vo.SearchParamVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 搜索微服务对外接口
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/28
 */
@RestController
@RequestMapping("search")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "搜索相关接口")
public class SearchController {

    private final SearchService searchService;

    /**
     * 分页搜索小说列表接口
     * */
    @ApiOperation("分页搜索小说列表接口")
    @GetMapping("searchByPage")
    public ResultBean<PageBean<EsBookVO>> searchByPage(SearchParamVO paramVO, @ApiParam("查询页码") @RequestParam(value = "curr", defaultValue = "1") int page, @ApiParam("每页大小") @RequestParam(value = "limit", defaultValue = "20") int pageSize){
        PageBean<EsBookVO> pageBean = searchService.searchBook(paramVO,page,pageSize);
        return ResultBean.ok(pageBean);
    }



}
