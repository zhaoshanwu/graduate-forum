package service;

import com.sw.utile.IDUtile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestUtile {

    @Test
    public void getNewDate() {
        System.out.println(IDUtile.getNewDate());
    }
}
