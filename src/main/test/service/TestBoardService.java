package service;

import com.sw.entity.Board;
import com.sw.service.BoardService;
import com.sw.utile.IDUtile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestBoardService {

    @Autowired
    private BoardService boardService;

    @Test
    public void selectBoardByParentBoardId() {
        List<Board> boardList = boardService.selectBoardByParentBoardId("001");
        System.out.println(boardList);
    }

    @Test
    public void selectBoardByBoardName() {
        String boardId = boardService.selectBoardByBoardName("李白");
        System.out.println(boardId);
    }
    @Test
    public void selectBoardByLikeBoardName() {
        List<Board> boardList = boardService.selectBoardByLikeBoardName("白", "正常", 0, 3);
        System.out.println(boardList);
    }

    @Test
    public void selectBoardByUserId() {
        Board board = boardService.selectBoardByUserId("004", "正常", 0, 3);
        System.out.println(board);
    }

    @Test
    public void insertBoard() {
        Board board = new Board();
        board.setBoardId(IDUtile.createId("版块"));
        board.setBoardName("李清照");
        board.setParentBoardId("001");
        board.setUserId("004");
        board.setEstablishDate(IDUtile.getNewDate());
        board.setRemark("");

        int re = boardService.insertBoard(board);
        System.out.println(re);
    }

    @Test
    public void updateBoard() {
        Board board = new Board();
        board.setBoardId("011210317001");
        board.setUserId("005");

        int re = boardService.updateBoard(board);
        System.out.println(re);
    }

    @Test
    public void deleteBoard() {
        int re = boardService.deleteBoard("011210317001");
        System.out.println(re);
    }
}
