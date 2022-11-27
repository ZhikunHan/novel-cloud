package com.hantiv.novel.book.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;

@Data
public class Book implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "作品方向，0：男频，1：女频'")
    private Byte workDirection;

    @ApiModelProperty(value = "分类ID")
    private Integer catId;

    @ApiModelProperty(value = "分类名")
    private String catName;

    @ApiModelProperty(value = "小说封面")
    private String picUrl;

    @ApiModelProperty(value = "小说名")
    private String bookName;

    @ApiModelProperty(value = "作者id")
    private Long authorId;

    @ApiModelProperty(value = "作者名")
    private String authorName;

    @ApiModelProperty(value = "书籍描述")
    private String bookDesc;

    @ApiModelProperty(value = "评分")
    private Float score;

    @ApiModelProperty(value = "书籍状态，0：连载中，1：已完结")
    private Byte bookStatus;

    @ApiModelProperty(value = "点击量")
    private Long visitCount;

    @ApiModelProperty(value = "总字数")
    private Integer wordCount;

    @ApiModelProperty(value = "评论数")
    private Integer commentCount;

    @ApiModelProperty(value = "最新目录ID")
    private Long lastIndexId;

    @ApiModelProperty(value = "最新目录名")
    private String lastIndexName;

    @ApiModelProperty(value = "最新目录更新时间")
    private Date lastIndexUpdateTime;

    @ApiModelProperty(value = "是否收费，1：收费，0：免费")
    private Byte isVip;

    @ApiModelProperty(value = "状态，0：入库，1：上架")
    private Byte status;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "爬虫源站ID")
    private Integer crawlSourceId;

    @ApiModelProperty(value = "抓取的源站小说ID")
    private String crawlBookId;

    @ApiModelProperty(value = "最后一次的抓取时间")
    private Date crawlLastTime;

    @ApiModelProperty(value = "是否已停止更新，0：未停止，1：已停止")
    private Byte crawlIsStop;

}