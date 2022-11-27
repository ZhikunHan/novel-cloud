package com.hantiv.novel.book.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
public class BookContent {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "目录ID")
    private Long indexId;

    @ApiModelProperty(value = "小说章节内容")
    private String content;

}