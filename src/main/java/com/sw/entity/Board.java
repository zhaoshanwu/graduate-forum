package com.sw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Board implements Serializable {
    // 版块ID
    private String boardId;
    // 父版块ID
    private String parentBoardId;
    // 版块名
    private String boardName;
    // 版主ID
    private String userId;
    // 创建时间
    private Timestamp establishDate;
    // 版块描述
    private String remark;

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getParentBoardId() {
        return parentBoardId;
    }

    public void setParentBoardId(String parentBoardId) {
        this.parentBoardId = parentBoardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String masterId) {
        this.userId = masterId;
    }

    public Timestamp getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Timestamp establishDate) {
        this.establishDate = establishDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "boardId='" + boardId + '\'' +
                ", parentBoardId='" + parentBoardId + '\'' +
                ", boardName='" + boardName + '\'' +
                ", userId='" + userId + '\'' +
                ", establishDate=" + establishDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
