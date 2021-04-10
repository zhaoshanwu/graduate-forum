package service;

import com.sw.entity.Comment;
import com.sw.service.CommentService;
import com.sw.utile.IDUtile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestCommentService {

    @Autowired
    private CommentService commentService;

    @Test
    public void selectCommentByPostId() {
        List<Comment> commentList = commentService.selectCommentByPostId("100210320001", "正常", 0, 3);
        System.out.println(commentList);
    }

    @Test
    public void selectCommentByUserId() {
        List<Comment> commentList = commentService.selectCommentByUserId("001", "正常", 0, 3);
        System.out.println(commentList);
    }

    @Test
    public void insertComment() {
        Comment comment = new Comment();
        comment.setCommentId(IDUtile.createId("评论"));
        comment.setPostId("100210320001");
        comment.setUserId("001");
        comment.setContent("啊");
        comment.setCommentDate(IDUtile.getNewDate());
        comment.setPraise(1);
        comment.setDisagree(1);
        comment.setRevert(0);
        comment.setStatus("正常");

        int re = commentService.insertComment(comment);
        System.out.println(re);
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();
        comment.setCommentId("101210320004");
        comment.setPraise(4);

        int re = commentService.updateComment(comment);
        System.out.println(re);
    }

    @Test
    public void deleteComment() {
        int re = commentService.deleteComment("101210320004");
        System.out.println(re);
    }
}
