package com.hantiv.novel.news.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hantiv.novel.news.entity.News;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 新闻VO对象
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@Data
public class NewsVO extends News {

    @ApiModelProperty(value = "新闻发布时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createTime;
}
