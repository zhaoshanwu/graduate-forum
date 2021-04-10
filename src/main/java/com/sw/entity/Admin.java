package com.sw.entity;

import java.io.Serializable;

public class Admin implements Serializable {

    // 管理员账号
    private String adminNumber;
    // 管理员昵称
    private String adminName;
    // 管理员密码
    private String adminPassword;

    public String getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(String adminNumber) {
        this.adminNumber = adminNumber;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminNumber='" + adminNumber + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    public static class BoardName implements Serializable {
        // 版块名
        private String boardName;
        // 父版块名
        private String parentBoardName;

        public String getBoardName() {
            return boardName;
        }

        public void setBoardName(String boardName) {
            this.boardName = boardName;
        }

        public String getParentBoardName() {
            return parentBoardName;
        }

        public void setParentBoardName(String parentBoardName) {
            this.parentBoardName = parentBoardName;
        }

        @Override
        public String toString() {
            return "BoardName{" +
                    "boardName='" + boardName + '\'' +
                    ", parentBoardName='" + parentBoardName + '\'' +
                    '}';
        }
    }
}
