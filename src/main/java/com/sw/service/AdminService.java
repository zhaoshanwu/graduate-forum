package com.sw.service;

import com.sw.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AdminService {

    // 根据管理员账户和密码查询管理员信息
    public Admin selectAdminByNP(String adminNumber, String adminPassword);

    // 根据管理员账号，修改管理员昵称
    public Integer updateAdminName(String adminNumber, String adminName);

    // 根据管理员账号，修改管理员密码
    public Integer updateAdminPassword(String adminNumber, String adminPassword);
}
