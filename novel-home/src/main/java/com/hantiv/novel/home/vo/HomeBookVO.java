package com.hantiv.novel.home.vo;

import com.hantiv.novel.home.entity.HomeBook;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 首页小说VO对象
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@Data
public class HomeBookVO extends HomeBook implements Serializable {

    @ApiModelProperty(value = "小说名")
    private String bookName;

    @ApiModelProperty(value = "小说封面")
    private String picUrl;

    @ApiModelProperty(value = "作者名")
    private String authorName;

    @ApiModelProperty(value = "小说简介")
    private String bookDesc;

    @ApiModelProperty(value = "小说评分")
    private Float score;


    @Override
    public String toString() {
        return super.toString();
    }
}
