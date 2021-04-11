package com.sw.service.impl;

import com.sw.dao.MessageDao;
import com.sw.dao.UserDao;
import com.sw.entity.Message;
import com.sw.entity.User;
import com.sw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @Override
    public Integer selectUserCount(String status, String userType) {
        return userDao.selectUserCount(status, userType);
    }

    @Override
    public List<User> selectUserAll(String status, String userType, Integer start, Integer count) {
        return userDao.selectUserAll(status, userType, start, count);
    }

    @Override
    public List<User> selectUserByName(String userName, Integer start, Integer count) {
        StringBuffer userNameStr = new StringBuffer();
        userNameStr.append("%");
        userNameStr.append(userName);
        userNameStr.append("%");
        return userDao.selectUserByName(userNameStr.toString(), start, count);
    }

    @Override
    public Integer selectUserByNameCount(String userName) {
        StringBuffer userNameStr = new StringBuffer();
        userNameStr.append("%");
        userNameStr.append(userName);
        userNameStr.append("%");
        return userDao.selectUserByNameCount(userNameStr.toString());
    }

    @Override
    public User selectUserById(String userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public String selectUserByNumber(String userNumber) {
        return userDao.selectUserByNumber(userNumber);
    }

    @Override
    public User selectUserByNP(String userNumber, String userPassword) {
        return userDao.selectUserByNP(userNumber, userPassword);
    }

    @Override
    public int selectUserNum(String status) {
        return userDao.selectUserNum(status);
    }

    @Override
    public int insertUser(User user, Message message) {
        return userDao.insertUser(user) + messageDao.insertMessage(message);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(String userId) {
        return messageDao.deleteMessage(userId) + userDao.deleteUser(userId);
    }

    @Override
    public int deleteMuchUser(String[] userIds) {
        return messageDao.deleteMuchMessage(userIds) + userDao.deleteMuchUser(userIds);
    }
}
