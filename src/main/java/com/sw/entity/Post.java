package com.sw.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Post implements Serializable {

    // 帖子ID
    private String postId;
    // 帖子标题
    private String title;
    // 所属版块ID
    private String boardId;
    // 发帖人ID
    private String initiateId;
    // 审核人ID
    private String auditId;
    // 内容
    private String content;
    // 发帖时间
    private Timestamp publishDate;
    // 点击量
    private Integer click;
    // 点赞量
    private Integer praise;
    // 踩量
    private Integer disagree;
    // 评论量
    private Integer comment;
    // 推荐
    private Boolean recommend;
    // 置顶
    private Boolean top;
    // 精华
    private Boolean elite;
    // 状态 正常 冻结 审核中
    private String status;
    // 删帖时间
    private Timestamp DeleteDate;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getInitiateId() {
        return initiateId;
    }

    public void setInitiateId(String initiateId) {
        this.initiateId = initiateId;
    }

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getDisagree() {
        return disagree;
    }

    public void setDisagree(Integer disagree) {
        this.disagree = disagree;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Boolean getElite() {
        return elite;
    }

    public void setElite(Boolean elite) {
        this.elite = elite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDeleteDate() {
        return DeleteDate;
    }

    public void setDeleteDate(Timestamp deleteDate) {
        DeleteDate = deleteDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", title='" + title + '\'' +
                ", boardId='" + boardId + '\'' +
                ", initiateId='" + initiateId + '\'' +
                ", auditId='" + auditId + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", click=" + click +
                ", praise=" + praise +
                ", disagree=" + disagree +
                ", comment=" + comment +
                ", recommend=" + recommend +
                ", top=" + top +
                ", elite=" + elite +
                ", status='" + status + '\'' +
                ", DeleteDate=" + DeleteDate +
                '}';
    }
}
