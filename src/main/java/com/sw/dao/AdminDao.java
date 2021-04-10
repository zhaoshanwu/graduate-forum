package com.sw.dao;

import com.sw.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    // 根据管理员账户和密码查询管理员信息
    public Admin selectAdminByNP(@Param("adminNumber") String adminNumber, @Param("adminPassword") String adminPassword);

    // 根据管理员账号，修改管理员昵称
    public Integer updateAdminName(@Param("adminNumber") String adminNumber, @Param("adminName") String adminName);

    // 根据管理员账号，修改管理员密码
    public Integer updateAdminPassword(@Param("adminNumber") String adminNumber, @Param("adminPassword") String adminPassword);

}
