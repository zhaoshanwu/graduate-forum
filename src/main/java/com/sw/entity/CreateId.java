package com.sw.entity;

import java.io.Serializable;

public class CreateId implements Serializable {
    // idDate的日期生成的最后一个ID
    private Integer dayId;
    // 最后一个生成ID的日期
    private String idDate;

    public Integer getDayId() {
        return dayId;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    public String getIdDate() {
        return idDate;
    }

    public void setIdDate(String idDate) {
        this.idDate = idDate;
    }

    @Override
    public String toString() {
        return "CreateId{" +
                "dayId=" + dayId +
                ", idDate='" + idDate + '\'' +
                '}';
    }
}
