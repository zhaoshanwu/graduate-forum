package com.sw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Visit implements Serializable {
    // 编号
    private Integer num;
    // 用户ID
    private String visitUserId;
    // 帖子ID
    private String visitPostId;
    // 访问时间
    private Timestamp visitDate;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getVisitUserId() {
        return visitUserId;
    }

    public void setVisitUserId(String visitUserId) {
        this.visitUserId = visitUserId;
    }

    public String getVisitPostId() {
        return visitPostId;
    }

    public void setVisitPostId(String visitPostId) {
        this.visitPostId = visitPostId;
    }

    public Timestamp getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "num=" + num +
                ", visitUserId='" + visitUserId + '\'' +
                ", visitPostId='" + visitPostId + '\'' +
                ", visitDate=" + visitDate +
                '}';
    }
}
