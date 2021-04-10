package com.sw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Revert implements Serializable {
    // 回复ID
    private String revertId;
    // 所属评论ID
    private String commentId;
    // 回复人ID
    private String userId;
    // 回复内容
    private String content;
    // 回复时间
    private Timestamp revertDate;
    // 点赞数
    private Integer praise;
    // 踩数
    private Integer disagree;
    // 状态
    private String status;

    public String getRevertId() {
        return revertId;
    }

    public void setRevertId(String revertId) {
        this.revertId = revertId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getRevertDate() {
        return revertDate;
    }

    public void setRevertDate(Timestamp comment_date) {
        this.revertDate = comment_date;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "reverts{" +
                "revertId='" + revertId + '\'' +
                ", commentId='" + commentId + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", revertDate=" + revertDate +
                ", praise=" + praise +
                ", disagree=" + disagree +
                ", status='" + status + '\'' +
                '}';
    }
}
