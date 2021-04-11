package service;

import com.sw.entity.Message;
import com.sw.entity.User;
import com.sw.service.UserService;
import com.sw.utile.IDUtile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void selectUserAll() {
        List<User> userList = userService.selectUserAll("正常", "普通用户", 0, 3);
        System.out.println(userList);
    }

    @Test
    public void selectUserByName() {
        List<User> userList = userService.selectUserByName("鼠", 0, 2);
        System.out.println(userList);
    }

    @Test
    public void selectUserById() {
        User user = userService.selectUserById("001");
        System.out.println(user);
    }

    @Test
    public void selectUserByNumber() {
        String userId = userService.selectUserByNumber("111");
        System.out.println(userId);
    }

    @Test
    public void selectUserByNP() {
        User user = userService.selectUserByNP("zishu","shu");
        System.out.println(user);
    }

    @Test
    public void insertUser() {
        String userId = IDUtile.createId("用户");

        User user = new User();
        user.setUserId(userId);
        user.setUserName("亥猪");
        user.setUserNumber("haizhu");
        user.setUserPassword("zhu");
        user.setStatus("正常");
        user.setExperience(0);
        user.setUserType("普通用户");
        user.setRegisterDate(IDUtile.getNewDate());

        Message message = new Message();
        message.setUserId(userId);

        int re = userService.insertUser(user, message);
        System.out.println(re);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUserId("012");
        user.setUserName("虚构");

        int re = userService.updateUser(user);
        System.out.println(re);
    }

    @Test
    public void deleteUser() {
        int re = userService.deleteUser("000210316002");
        System.out.println(re);
    }

    @Test
    public void test() {
        String status = "正常";
        String userType = "全部";

        status = (status == "全部") ? null : status;
        userType = (userType == "全部") ? null : userType;

        System.out.println(status + userType);
    }
}
