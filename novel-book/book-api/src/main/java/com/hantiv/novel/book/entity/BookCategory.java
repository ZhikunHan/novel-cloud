package com.hantiv.novel.book.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;

@Data
public class BookCategory {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "作品方向，0：男频，1：女频'")
    private Byte workDirection;

    @ApiModelProperty(value = "分类名")
    private String name;

    @ApiModelProperty(value = "排序")
    private Byte sort;

    private Long createUserId;

    private Date createTime;

    private Long updateUserId;

    private Date updateTime;

}