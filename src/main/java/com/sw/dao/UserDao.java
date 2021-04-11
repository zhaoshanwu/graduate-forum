package com.sw.dao;

import com.sw.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface UserDao {

    // 获取用户数
    public Integer selectUserCount(@Param("status") String status,
                                   @Param("userType") String userType);

    // 获取所有用户账户，通过状态和用户类型筛选
    public List<User> selectUserAll(@Param("status") String status,
                                    @Param("userType") String userType,
                                    @Param("start") Integer start,
                                    @Param("count") Integer count);

    // 根据用户昵称模糊查询用户账户
    public List<User> selectUserByName(@Param("userName") String userName,
                                       @Param("start") Integer start,
                                       @Param("count") Integer count);

    // 根据用户昵称模糊查询用户账户
    public Integer selectUserByNameCount(@Param("userName") String userName);

    // 根据用户ID查询用户账户信息
    public User selectUserById(@Param("userId") String userId);

    // 根据用户账号查询用户
    public String selectUserByNumber(@Param("userNumber") String userNumber);

    // 根据用户账号和密码查询用户
    public User selectUserByNP(@Param("userNumber") String userNumber, @Param("userPassword") String userPassword);

    // 查询用户总数
    public int selectUserNum(@Param("status") String status);

    // 根据用户账户信息插入用户
    public int insertUser(User user);

    // 根据用户账户信息，以用户ID为根据修改用户账户
    public int updateUser(User user);

    // 根据用户ID删除用户
    public int deleteUser(@Param("userId") String userId);

    // 根据用户ID批量删除用户
    public int deleteMuchUser(String[] userIds);
}
