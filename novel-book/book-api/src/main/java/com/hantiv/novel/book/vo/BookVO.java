package com.hantiv.novel.book.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hantiv.novel.book.entity.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 小说VO对象
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@Data
public class BookVO extends Book{

    @ApiModelProperty(value = "最新目录更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "MM/dd HH:mm")
    private Date lastIndexUpdateTime;


}
