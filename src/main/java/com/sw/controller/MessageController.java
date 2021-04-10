package com.sw.controller;

import com.sw.entity.Message;
import com.sw.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 根据用户ID查询用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/get/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Message selectMessageById(String userId) {
        Message message = messageService.selectMessageById(userId);

        if (message == null) {
            return null;
        } else {
            return message;
        }
    }

    /**
     * 根据MessageId修改用户信息
     * @param message
     * @return
     */
    @RequestMapping(value = "/put/message",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updateMessage(Message message) {
        int re = messageService.updateMessage(message);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }
}
