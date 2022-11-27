package com.hantiv.novel.user.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;

@Data
public class UserBuyRecord {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "购买的小说ID")
    private Long bookId;

    @ApiModelProperty(value = "购买的小说名")
    private String bookName;

    @ApiModelProperty(value = "购买的章节ID")
    private Long bookIndexId;

    @ApiModelProperty(value = "购买的章节名")
    private String bookIndexName;

    @ApiModelProperty(value = "购买使用的屋币数量")
    private Integer buyAmount;

    @ApiModelProperty(value = "购买时间")
    private Date createTime;
}