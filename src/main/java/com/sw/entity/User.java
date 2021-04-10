package com.sw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class User implements Serializable {

    // 用户ID
    private String userId;
    // 用户昵称
    private String userName;
    // 用户账号
    private String userNumber;
    // 用户密码
    private String userPassword;
    // 状态 正常 冻结
    private String status;
    // 经验值
    private Integer experience;
    // 用户类型  版主  普通用户
    private String userType;
    // 注册时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp registerDate;
    // 最后登录时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp finallyDate;
    //个性签名
    private String signature;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public Timestamp getFinallyDate() {
        return finallyDate;
    }

    public void setFinallyDate(Timestamp finallyDate) {
        this.finallyDate = finallyDate;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", status='" + status + '\'' +
                ", experience=" + experience +
                ", userType='" + userType + '\'' +
                ", registerDate=" + registerDate +
                ", finallyDate=" + finallyDate +
                ", signature='" + signature + '\'' +
                '}';
    }
}
