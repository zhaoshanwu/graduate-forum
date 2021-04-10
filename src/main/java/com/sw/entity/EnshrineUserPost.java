package com.sw.entity;

import java.io.Serializable;

public class EnshrineUserPost implements Serializable {
    // 编号
    private Integer num;
    // 用户ID
    private String enshrineUserId;
    // 帖子ID
    private String byEnshrinePostId;
    // 收藏时间
    private String enshrineDate;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getEnshrineUserId() {
        return enshrineUserId;
    }

    public void setEnshrineUserId(String enshrineUserId) {
        this.enshrineUserId = enshrineUserId;
    }

    public String getByEnshrinePostId() {
        return byEnshrinePostId;
    }

    public void setByEnshrinePostId(String byEnshrinePostId) {
        this.byEnshrinePostId = byEnshrinePostId;
    }

    public String getEnshrineDate() {
        return enshrineDate;
    }

    public void setEnshrineDate(String enshrineDate) {
        this.enshrineDate = enshrineDate;
    }

    @Override
    public String toString() {
        return "EnshrineUserPost{" +
                "num=" + num +
                ", enshrineUserId='" + enshrineUserId + '\'' +
                ", byEnshrinePostId='" + byEnshrinePostId + '\'' +
                ", enshrineDate='" + enshrineDate + '\'' +
                '}';
    }
}
