package com.hantiv.novel.crawl.entity;

import java.util.Date;

/**
 * @Author Zhikun Han
 * @Date Created in 16:47 2022/11/20
 * @Description:
 */
public class CrawlBatchTask {

    private Long id;

    private Integer sourceId;

    private Integer crawlCountSuccess;

    private Integer crawlCountTarget;

    private Byte taskStatus;

    private Date startTime;

    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getCrawlCountSuccess() {
        return crawlCountSuccess;
    }

    public void setCrawlCountSuccess(Integer crawlCountSuccess) {
        this.crawlCountSuccess = crawlCountSuccess;
    }

    public Integer getCrawlCountTarget() {
        return crawlCountTarget;
    }

    public void setCrawlCountTarget(Integer crawlCountTarget) {
        this.crawlCountTarget = crawlCountTarget;
    }

    public Byte getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Byte taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
