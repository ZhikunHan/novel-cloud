package com.hantiv.novel.book.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;
@Data
public class BookIndex {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "小说ID")
    private Long bookId;

    @ApiModelProperty(value = "目录号")
    private Integer indexNum;

    @ApiModelProperty(value = "目录名")
    private String indexName;

    @ApiModelProperty(value = "字数")
    private Integer wordCount;

    @ApiModelProperty(value = "是否收费，1：收费，0：免费")
    private Byte isVip;

    private Date createTime;

    private Date updateTime;

}