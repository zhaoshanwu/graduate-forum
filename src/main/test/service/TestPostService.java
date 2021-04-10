package service;

import com.sw.entity.Post;
import com.sw.service.PostService;
import com.sw.utile.IDUtile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestPostService {

    @Autowired
    private PostService postService;

    @Test
    public void selectPostCount() {
        System.out.println(postService.selectPostCount("正常", "置顶", true));
    }

    @Test
    public void selectPostNormalAll() {
        List<Post> postList = postService.selectPostNormalAll("正常",0,3);
        System.out.println(postList);
    }

    @Test
    public void selectLabelPostAll() {
        List<Post> postList = postService.selectLabelPostAll("置顶", "正常", 0, 2);
        System.out.println(postList);
    }

    @Test
    public void selectPostById() {
        Post post = postService.selectPostById("100210318005");
        System.out.println(post);
    }

    @Test
    public void selectPostByBoardId() {
        List<Post> postList = postService.selectPostByBoardId("001", "正常", 0, 3);
        System.out.println(postList);
    }

    @Test
    public void selectPostByInitiateId() {
        List<Post> postList = postService.selectPostByInitiateId("001", "正常", 0, 3);
        System.out.println(postList);
    }

    @Test
    public void selectPostByAuditId() {
        List<Post> postList = postService.selectPostByAuditId("004", "正常", 0, 3);
        System.out.println(postList);
    }

    @Test
    public void selectPostSum() {
        Map<String, Integer> sumMap = new HashMap<String, Integer>();
        sumMap = postService.selectPostNum();

        for (String key : sumMap.keySet()) {
            System.out.println("key: " + key + "  value: " + sumMap.get(key));
        }
    }

    @Test
    public void insertPost() {
        Post post = new Post();
        post.setPostId(IDUtile.createId("帖子"));
        post.setTitle("行路难");
        post.setBoardId("001");
        post.setInitiateId("001");
        post.setAuditId("004");
        post.setContent("行路难，行路难");
        post.setPublishDate(IDUtile.getNewDate());
        post.setClick(3);
        post.setPraise(3);
        post.setDisagree(3);
        post.setComment(6);
        post.setRecommend(true);
        post.setTop(false);
        post.setElite(false);
        post.setStatus("正常");
        post.setDeleteDate(null);

        int re = postService.insertPost(post);
        System.out.println(re);
    }

    @Test
    public void updatePost() {
        Post post = new Post();
        post.setPostId("100210320003");
        post.setTitle("将进酒");

        int re = postService.updatePost(post);
        System.out.println(re);
    }

    @Test
    public void updateSoftPost() {
        int re = postService.updateSoftPost("100210318005", IDUtile.getNewDate());
        System.out.println(re);
    }

    @Test
    public void deleteStiffPost() {
        int re = postService.deleteStiffPost("100210318005");
        System.out.println(re);
    }
}
