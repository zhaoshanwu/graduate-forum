package com.sw.service.impl;

import com.sw.dao.MessageDao;
import com.sw.entity.Message;
import com.sw.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MessageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public Message selectMessageById(String userId) {
        return messageDao.selectMessageById(userId);
    }

    @Override
    public int updateMessage(Message message) {
        return messageDao.updateMessage(message);
    }
}
