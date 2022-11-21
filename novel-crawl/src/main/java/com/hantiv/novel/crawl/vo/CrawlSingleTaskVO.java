package com.hantiv.novel.crawl.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hantiv.novel.crawl.entity.CrawlSingleTask;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Author Zhikun Han
 * @Date Created in 16:41 2022/11/20
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CrawlSingleTaskVO extends CrawlSingleTask {
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;

    @Override
    public String toString() {
        return super.toString();
    }
}
