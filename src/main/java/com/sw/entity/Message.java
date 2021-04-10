package com.sw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {
    // 用户ID
    private String userId;
    // 年龄
    private Integer age;
    // 身高
    private Integer stature;
    // 体重
    private Integer weight;
    // 性别
    private String sex;
    // 出生日期
    private Timestamp birth;
    // 居住地
    private String site;
    // 电话号码
    private String phone;
    // 喜欢的古人
    private String loveAncient;
    // 爱好
    private String hobby;
    // 工作
    private String work;
    // 邮箱
    private String mail;
    // QQ
    private String qq;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStature() {
        return stature;
    }

    public void setStature(Integer stature) {
        this.stature = stature;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoveAncient() {
        return loveAncient;
    }

    public void setLoveAncient(String loveAncient) {
        this.loveAncient = loveAncient;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "Message{" +
                "userId='" + userId + '\'' +
                ", age=" + age +
                ", stature=" + stature +
                ", weight=" + weight +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", site='" + site + '\'' +
                ", phone='" + phone + '\'' +
                ", loveAncient='" + loveAncient + '\'' +
                ", hobby='" + hobby + '\'' +
                ", work='" + work + '\'' +
                ", mail='" + mail + '\'' +
                ", qq='" + qq + '\'' +
                '}';
    }
}
