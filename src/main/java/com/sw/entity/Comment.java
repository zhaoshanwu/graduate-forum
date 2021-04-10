package com.sw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {
    // 评论ID
    private String commentId;
    // 所属帖子ID
    private String postId;
    // 评论人ID
    private String userId;
    // 评论内容
    private String content;
    // 评论时间
    private Timestamp commentDate;
    // 点赞数
    private Integer praise;
    // 踩数
    private Integer disagree;
    // 回复数
    private Integer revert;
    // 状态
    private String status;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
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

    public Integer getRevert() {
        return revert;
    }

    public void setRevert(Integer revert) {
        this.revert = revert;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "comment{" +
                "commentId='" + commentId + '\'' +
                ", postId='" + postId + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", commentDate=" + commentDate +
                ", praise=" + praise +
                ", disagree=" + disagree +
                ", revert=" + revert +
                ", status='" + status + '\'' +
                '}';
    }
}
