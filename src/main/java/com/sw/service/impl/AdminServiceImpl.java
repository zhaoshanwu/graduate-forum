package com.sw.service.impl;

import com.sw.dao.AdminDao;
import com.sw.entity.Admin;
import com.sw.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin selectAdminByNP(String adminNumber, String adminPassword) {
        return adminDao.selectAdminByNP(adminNumber, adminPassword);
    }

    @Override
    public Integer updateAdminName(String adminNumber, String adminName) {
        return adminDao.updateAdminName(adminNumber, adminName);
    }

    @Override
    public Integer updateAdminPassword(String adminNumber, String adminPassword) {
        return adminDao.updateAdminPassword(adminNumber, adminPassword);
    }
}
