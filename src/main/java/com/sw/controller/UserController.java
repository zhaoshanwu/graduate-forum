package com.sw.controller;

import com.sw.entity.Message;
import com.sw.entity.User;
import com.sw.service.UserService;
import com.sw.utile.IDUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取该状态类型的用户数
     * @param status
     * @param userType
     * @return
     */
    @RequestMapping(value = "/get/count",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Integer selectUserCount(String status, String userType) {
        if (status != null && status.equals("全部")) {
            status = null;
        }
        if (userType != null && userType.equals("全部")) {
            userType = null;
        }
        return userService.selectUserCount(status, userType);
    }

    /**
     * 根据用户状态和用户类型查询所有符合要求的用户
     * @param status
     * @param userType
     * @return
     */
    @RequestMapping(value = "/get/all",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<User> selectUserAll(String status, String userType, Integer start, Integer count) {
        if (status != null && status.equals("全部")) {
            status = null;
        }
        if (userType != null && userType.equals("全部")) {
            userType = null;
        }

        System.out.println(status + userType);

        List<User> userList = userService.selectUserAll(status, userType, start, count);
        return userList;
    }

    /**
     * 根据用户ID查询用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/get/by/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User selectUserById(String userId) {
        User user = userService.selectUserById(userId);
        return user;
    }

    /**
     * 根据用户昵称模糊查询所有符合要求的用户
     * @param userName
     * @return
     */
    @RequestMapping(value = "/get/by/name",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<User> selectUserByName(String userName, Integer start, Integer count) {
        List<User> userList = userService.selectUserByName(userName, start, count);
        return userList;
    }

    /**
     * 根据用户昵称模糊查询所有符合要求的用户个数
     * @param userName
     * @return
     */
    @RequestMapping(value = "/get/by/name/count",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Integer selectUserByNameCount(String userName) {
        return userService.selectUserByNameCount(userName);
    }

    /**
     * 根据用户账户和密码查找用户信息，进行登录验证
     * @param userNumber
     * @param userPassword
     * @return
     */
    @RequestMapping(value = "/get/by/number/password",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User selectUserByNP(String userNumber, String userPassword) {
        User user = userService.selectUserByNP(userNumber, userPassword);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * 添加用户
     * @param userNumber
     * @param userName
     * @param userPassword
     * @return
     */
    @RequestMapping(value = "/post/user",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean insertUser(String userNumber, String userName, String userPassword, String signature) {

        // 根据用户名进行用户查询，如果存在相同用户账户，则无法注册
        String oldUserId = userService.selectUserByNumber(userNumber);

        if (oldUserId != null) {
            System.out.println("false");
            return false;
        }

        String userId = IDUtile.createId("用户");

        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserNumber(userNumber);
        user.setUserPassword(userPassword);
        user.setStatus("正常");
        user.setExperience(0);
        user.setUserType("普通用户");
        user.setRegisterDate(IDUtile.getNewDate());
        if (signature != null) {
            user.setSignature(signature);
        }

        Message message = new Message();
        message.setUserId(userId);

        int re = userService.insertUser(user, message);

        if (re == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/put/user",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updateUser(User user) {
        int re = userService.updateUser(user);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据用户ID删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delete/user",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean deleteUser(String userId) {
        int re = userService.deleteUser(userId);

        if (re == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根于用户ID批量删除用户
     * @param userList
     * @return
     */
    @RequestMapping(value = "/delete/multi/user",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean deleteMuchUser(List<User> userList) {

        String[] userIds = new String[userList.size()];

        for (int index = 0; index < userList.size(); index++) {
            userIds[index] = userList.get(index).getUserId();
        }


        int re = userService.deleteMuchUser(userIds);

        if (re >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
