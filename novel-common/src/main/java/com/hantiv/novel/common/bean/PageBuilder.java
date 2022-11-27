package com.hantiv.novel.common.bean;

import com.github.pagehelper.PageInfo;
import com.hantiv.novel.common.bean.PageBean;

import java.util.List;

/**
 * @Author Zhikun Han
 * @Date Created in 17:17 2022/11/27
 * @Description:
 */
public class PageBuilder{

    private PageBuilder(){};

    public static <T> PageBean<T> build(List<T> list){
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return PageBean.of(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(),pageInfo.getList());
    }

}