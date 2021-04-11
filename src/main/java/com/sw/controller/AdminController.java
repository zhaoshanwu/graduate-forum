package com.sw.controller;

import com.sw.entity.Admin;
import com.sw.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录验证账号密码， 如果存在于数据库则存入session进行登录
     * @param adminNumber
     * @param adminPassword
     * @return
     */
    @RequestMapping(value = "/get/number/password",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Admin getAdminByNP(String adminNumber, String adminPassword) {
        Admin admin = adminService.selectAdminByNP(adminNumber, adminPassword);
        System.out.println(admin);

        if (admin != null) {
            return admin;
        } else {
            return null;
        }
    }

    /**
     * 修改管理员昵称
     * @param adminNumber
     * @param adminName
     * @return
     */
    @RequestMapping(value = "/put/name",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updateAdminName(String adminNumber, String adminName) {
        Integer re = adminService.updateAdminName(adminNumber, adminName);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改管理员密码
     * @param adminNumber
     * @param adminPassword
     * @return
     */
    @RequestMapping(value = "/put/password",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updateAdminPassword(String adminNumber, String adminPassword) {
        Integer re = adminService.updateAdminPassword(adminNumber, adminPassword);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }
}
