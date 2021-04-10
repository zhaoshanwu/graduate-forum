package com.sw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class AttentionUserUser implements Serializable {
    // 编号
    private Integer num;
    // 关注人ID
    private String attentionUserId;
    // 被关注人ID
    private String byAttentionUserId;
    // 关注时间
    private Timestamp attentionDate;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getAttentionUserId() {
        return attentionUserId;
    }

    public void setAttentionUserId(String attentionUserId) {
        this.attentionUserId = attentionUserId;
    }

    public String getByAttentionUserId() {
        return byAttentionUserId;
    }

    public void setByAttentionUserId(String byAttentionUserId) {
        this.byAttentionUserId = byAttentionUserId;
    }

    public Timestamp getAttentionDate() {
        return attentionDate;
    }

    public void setAttentionDate(Timestamp attentionDate) {
        this.attentionDate = attentionDate;
    }

    @Override
    public String toString() {
        return "AttentionUserUser{" +
                "num=" + num +
                ", attentionUserId='" + attentionUserId + '\'' +
                ", byAttentionUserId='" + byAttentionUserId + '\'' +
                ", attentionDate=" + attentionDate +
                '}';
    }
}
