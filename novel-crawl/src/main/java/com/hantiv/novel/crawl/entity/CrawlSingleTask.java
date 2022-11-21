package com.hantiv.novel.crawl.entity;

import java.util.Date;

/**
 * @Author Zhikun Han
 * @Date Created in 16:45 2022/11/20
 * @Description:
 */
public class CrawlSingleTask {

    private Long id;

    private Integer sourceId;

    private String sourceName;

    private String sourceBookId;

    private Integer catId;

    private String bookName;

    private String authorName;

    private Byte taskStatus;

    private Byte excCount;

    private Date createTime;

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

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getSourceBookId() {
        return sourceBookId;
    }

    public void setSourceBookId(String sourceBookId) {
        this.sourceBookId = sourceBookId == null ? null : sourceBookId.trim();
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public Byte getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Byte taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Byte getExcCount() {
        return excCount;
    }

    public void setExcCount(Byte excCount) {
        this.excCount = excCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
