package com.sw.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface VisitDao {

    // 添加用户帖子浏览记录
    public int insertVisit(@Param("userId") String userId,
                           @Param("postId") String postId,
                           @Param("visitDate")Timestamp visitDate);

    // 删除用户帖子浏览记录
    public int deleteVisit();
}
