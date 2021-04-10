package com.sw.dao;

import com.sw.entity.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {

    // 根据用户ID查询用户信息
    public Message selectMessageById(@Param("userId") String userId);

    // 根据用户ID分页查询该用户关注的用户信息
    public List<Message> selectAttentionUserByUserId(@Param("userId") String userId,
                                                     @Param("status") String status,
                                                     @Param("start") Integer start,
                                                     @Param("count") Integer count);

    // 根据用户信息对象插入用户信息
    public int insertMessage(Message message);

    // 根据用户信息对象修改用户信息
    public int updateMessage(Message message);

    // 删除用户信息
    public int deleteMessage(@Param("userId") String userId);
}
