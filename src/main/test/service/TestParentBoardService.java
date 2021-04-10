package service;

import com.sw.entity.ParentBoard;
import com.sw.entity.combination.BoardName;
import com.sw.service.ParentBoardService;
import com.sw.utile.IDUtile;
import javafx.scene.Parent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestParentBoardService {

    @Autowired
    private ParentBoardService parentBoardService;

    @Test
    public void selectParentBoardAll() {
        List<ParentBoard> parentBoardList = parentBoardService.selectParentBoardAll();
        System.out.println(parentBoardList);
    }

    @Test
    public void selectParentBoardNameByPostId() {
        BoardName boardName = parentBoardService.selectParentBoardNameByPostId("003");
        System.out.println(boardName);
    }

    @Test
    public void insertParentBoard() {
        ParentBoard parentBoard = new ParentBoard();
        parentBoard.setParentBoardId(IDUtile.createId("父版块"));
        parentBoard.setParentBoardName("战争");
        parentBoard.setParentBoardDate(IDUtile.getNewDate());
        parentBoard.setRemark("");

        int re = parentBoardService.insertParentBoard(parentBoard);
        System.out.println(re);
    }

    @Test
    public void updateParentBoard() {
        ParentBoard parentBoard = new ParentBoard();
        parentBoard.setParentBoardId("010210316005");
        parentBoard.setParentBoardName("被贬");
        parentBoard.setParentBoardDate(IDUtile.getNewDate());
        parentBoard.setRemark("");

        int re = parentBoardService.updateParentBoard(parentBoard);
        System.out.println(re);
    }

    @Test
    public void deleteParentBoard() {
        int re = parentBoardService.deleteParentBoard("010210316005");
        System.out.println(re);
    }
}
