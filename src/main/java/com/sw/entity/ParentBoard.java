package com.sw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ParentBoard implements Serializable {
    // 父版块ID
    private String parentBoardId;
    // 父版块名
    private String parentBoardName;
    // 创建时间
    private Timestamp parentBoardDate;
    // 父版块说明
    private String remark;

    public String getParentBoardId() {
        return parentBoardId;
    }

    public void setParentBoardId(String parentBoardId) {
        this.parentBoardId = parentBoardId;
    }

    public String getParentBoardName() {
        return parentBoardName;
    }

    public void setParentBoardName(String parentBoardName) {
        this.parentBoardName = parentBoardName;
    }

    public Timestamp getParentBoardDate() {
        return parentBoardDate;
    }

    public void setParentBoardDate(Timestamp parentBoardDate) {
        this.parentBoardDate = parentBoardDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ParentBoard{" +
                "parentBoardId='" + parentBoardId + '\'' +
                ", parentBoardName='" + parentBoardName + '\'' +
                ", parentBoardDate=" + parentBoardDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
