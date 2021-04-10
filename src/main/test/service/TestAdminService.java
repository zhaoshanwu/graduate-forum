package service;

import com.sw.entity.Admin;
import com.sw.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestAdminService {

    @Autowired
    private AdminService adminService;

    @Test
    public void selectAdminByNP() {
        Admin admin = adminService.selectAdminByNP("admin", "0000");
        System.out.println(admin);
    }

    @Test
    public void updateAdminName() {
        Integer re = adminService.updateAdminName("admin", "小文同学");
        System.out.println(re);
    }

    @Test
    public void updateAdminPassword() {
        Integer re = adminService.updateAdminPassword("admin", "1111");
        System.out.println(re);
    }
}
