package com.sw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class AttentionUserBoard implements Serializable {
    // 编号
    private Integer num;
    // 用户ID
    private String attentionUserId;
    // 版块ID
    private String byAttentionBoardId;
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

    public String getByAttentionBoardId() {
        return byAttentionBoardId;
    }

    public void setByAttentionBoardId(String byAttentionBoardId) {
        this.byAttentionBoardId = byAttentionBoardId;
    }

    public Timestamp getAttentionDate() {
        return attentionDate;
    }

    public void setAttentionDate(Timestamp attentionDate) {
        this.attentionDate = attentionDate;
    }

    @Override
    public String toString() {
        return "attentionUserBoard{" +
                "num=" + num +
                ", attentionUserId='" + attentionUserId + '\'' +
                ", byAttentionBoardId='" + byAttentionBoardId + '\'' +
                ", attentionDate=" + attentionDate +
                '}';
    }
}
