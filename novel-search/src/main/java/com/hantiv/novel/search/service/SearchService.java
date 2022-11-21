package com.hantiv.novel.search.service;


import com.hantiv.novel.book.entity.Book;
import com.hantiv.novel.common.bean.PageBean;
import com.hantiv.novel.search.vo.EsBookVO;
import com.hantiv.novel.search.vo.SearchParamVO;


/**
 * 搜索服务接口
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/28
 */
public interface SearchService {

    /**
     * 导入到es
     * @param book 小说数据
     */
    void importToEs(Book book);

    /**
     * 搜索
     * @param params 搜索参数
     * @param page 当前页码
     * @param pageSize 每页大小
     * @return 分页信息
     */
    PageBean<EsBookVO> searchBook(SearchParamVO params, int page, int pageSize);


}
