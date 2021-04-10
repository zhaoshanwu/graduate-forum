package com.sw.service;

import com.sw.entity.Message;
import com.sw.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {

    // 获取所有用户账户，通过状态和用户类型筛选
    public List<User> selectUserAll(String status, String userType);

    // 根据用户昵称模糊查询用户账户
    public List<User> selectUserByName(String userName);

    // 根据用户ID查询用户账户信息
    public User selectUserById(String userId);

    // 根据用户账号查询用户
    public String selectUserByNumber(String userNumber);

    // 根据用户账号和密码查询用户
    public User selectUserByNP(String userNumber, String userPassword);

    // 查询用户数
    public int selectUserNum(String status);

    // 根据用户账户信息插入用户
    public int insertUser(User user, Message message);

    // 根据用户账户信息，以用户ID为根据修改用户账户
    public int updateUser(User user);

    // 根据用户ID删除用户
    public int deleteUser(String userId);
}
