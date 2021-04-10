package com.sw.service;

import com.sw.entity.Message;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MessageService {

    // 根据用户ID查询用户信息
    public Message selectMessageById(String userId);

    // 根据用户信息对象修改用户信息
    public int updateMessage(Message message);
}
