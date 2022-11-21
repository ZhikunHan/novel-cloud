package com.hantiv.novel.crawl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hantiv.novel.crawl.entity.CrawlSource;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Author Zhikun Han
 * @Date Created in 16:53 2022/11/20
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CrawlSourceVO extends CrawlSource {

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;



    @Override
    public String toString() {
        return super.toString();
    }
}
