package service;


import com.sw.entity.Message;
import com.sw.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestMessageService {

    @Autowired
    private MessageService messageService;

    @Test
    public void selectMessageById() {
        Message message = messageService.selectMessageById("000210316001");
        System.out.println(message);
    }
}
