package com.sw.utile;

import com.sw.entity.CreateId;
import com.sw.service.CreateIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ID由12位数字组成，类型为String
 * 1~3位：000：用户ID  001：版块ID  010：帖子ID  011：评论ID  100：回复ID
 * 4~9位：表示创建日期，yymmdd
 * 10~12位：当天第几个创建的ID
 */

@Component
public class IDUtile {

    @Autowired
    private CreateIdService createIdService;

    public static IDUtile idUtile;

    @PostConstruct
    public void init() {
        idUtile = this;
    }

    /**
     * 判断日期是否为当前日期
     * 如果不是，dayID归零,时间归为当前时间,返回false
     * 如果是当前日期，则获取当前已生成的最后一个ID号
      */
    public static Integer initializeDayID() {
        CreateId createId = idUtile.createIdService.selectCreateId();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(new Date());
        if (!createId.getIdDate().equals(newDate)) {
            // 不是当前日期，日期修改为当前日期并且ID初始化
            CreateId newCreateId = new CreateId();
            newCreateId.setDayId(0);
            newCreateId.setIdDate(newDate);
            idUtile.createIdService.updateCreateId(newCreateId);
            return 0;
        } else {
            return createId.getDayId();
        }
    }

    /**
     * 生成ID
     *
     * 拼接ID字符串
     * 将此次ID的顺序写入数据库
     * @return
     */
    public static String createId(String type) {
        Boolean error = false;
        Integer createId = initializeDayID() + 1;

        String orderId = String.format("%03d", createId);

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String newDate = sdf.format(new Date());

        StringBuffer Id = new StringBuffer();
        switch (type) {
            case "用户":
                Id.append("000");
                break;
            case "父版块":
                Id.append("010");
                break;
            case "版块":
                Id.append("011");
                break;
            case "帖子":
                Id.append("100");
                break;
            case "评论":
                Id.append("101");
                break;
            case "回复":
                Id.append("110");
                break;
            default:
                error = true;
        }
        Id.append(newDate);
        Id.append(orderId);

        CreateId newCreateId = new CreateId();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String newDate2 = sdf2.format(new Date());
        newCreateId.setDayId(createId);
        newCreateId.setIdDate(newDate2);
        idUtile.createIdService.updateCreateId(newCreateId);

        if (error) {
            return "";
        } else {
            return Id.toString();
        }
    }

    public static Timestamp getNewDate() {
        Date utilDate = new Date();
        Timestamp sqlDate = new Timestamp(utilDate.getTime());
        return sqlDate;
    }
}
