package com.hantiv.novel.user.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;

@Data
public class UserBookshelf {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "小说ID")
    private Long bookId;

    @ApiModelProperty(value = "上一次阅读的章节内容表ID")
    private Long preContentId;

    private Date createTime;

    private Date updateTime;

}