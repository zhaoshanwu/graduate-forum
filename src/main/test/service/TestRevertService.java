package service;

import com.sw.entity.Revert;
import com.sw.service.RevertService;
import com.sw.utile.IDUtile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestRevertService {

    @Autowired
    private RevertService revertService;

    @Test
    public void selectRevertByCommentId() {
        List<Revert> revertList = revertService.selectRevertByCommentId("001","正常", 0, 3);
        System.out.println(revertList);
    }

    @Test
    public void selectRevertByUserId() {
        List<Revert> revertList = revertService.selectRevertByUserId("001","正常", 0, 3);
        System.out.println(revertList);
    }

    @Test
    public void insertRevert() {
        Revert revert = new Revert();
        revert.setRevertId(IDUtile.createId("回复"));
        revert.setCommentId("001");
        revert.setUserId("001");
        revert.setContent("ccc");
        revert.setRevertDate(IDUtile.getNewDate());
        revert.setPraise(0);
        revert.setDisagree(0);
        revert.setStatus("正常");

        int re = revertService.insertRevert(revert);
        System.out.println(re);
    }

    @Test
    public void updateRevert() {
        Revert revert = new Revert();
        revert.setRevertId("110210320006");
        revert.setDisagree(4);

        int re = revertService.updateRevert(revert);
        System.out.println(re);
    }

    @Test
    public void deleteRevert() {
        int re = revertService.deleteRevert("110210320006");
        System.out.println(re);
    }
}
