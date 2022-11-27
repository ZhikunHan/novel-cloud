package com.hantiv.novel.book.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;

@Data
public class BookComment implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "小说ID")
    private Long bookId;

    @ApiModelProperty(value = "评价内容")
    private String commentContent;

    @ApiModelProperty(value = "回复数量")
    private Integer replyCount;

    @ApiModelProperty(value = "审核状态，0：待审核，1：审核通过，2：审核不通过")
    private Byte auditStatus;

    @ApiModelProperty(value = "评价时间")
    private Date createTime;

    @ApiModelProperty(value = "评价人")
    private Long createUserId;

}