package com.hantiv.novel.book.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;

@Data
public class BookCommentReply {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "评论ID")
    private Long commentId;

    @ApiModelProperty(value = "回复内容")
    private String replyContent;

    @ApiModelProperty(value = "审核状态，0：待审核，1：审核通过，2：审核不通过")
    private Byte auditStatus;

    @ApiModelProperty(value = "回复用户ID")
    private Date createTime;

    @ApiModelProperty(value = "回复时间")
    private Long createUserId;

}