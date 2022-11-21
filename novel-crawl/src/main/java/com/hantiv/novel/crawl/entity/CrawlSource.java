package com.hantiv.novel.crawl.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author Zhikun Han
 * @Date Created in 16:43 2022/11/20
 * @Description:
 */
public class CrawlSource {

    private Integer id;

    private String sourceName;

    private String crawlRule;

    private Byte sourceStatus;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getCrawlRule() {
        return crawlRule;
    }

    public void setCrawlRule(String crawlRule) {
        this.crawlRule = crawlRule == null ? null : crawlRule.trim();
    }

    public Byte getSourceStatus() {
        return sourceStatus;
    }

    public void setSourceStatus(Byte sourceStatus) {
        this.sourceStatus = sourceStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
