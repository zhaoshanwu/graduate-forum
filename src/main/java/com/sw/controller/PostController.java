package com.sw.controller;

import com.sw.entity.Post;
import com.sw.service.PostService;
import com.sw.service.UserService;
import com.sw.utile.IDUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    /**
     * 获取该状态该标签帖子的个数
     * @return
     */
    @RequestMapping(value = "/get/count",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Integer selectPostCount(String status, String label, Boolean labelYN) {
        return postService.selectPostCount(status, label, labelYN);
    }

    /**
     * 根据帖子状态分页查询帖子信息
     * @param status
     * @param start
     * @param count
     * @return
     */
    @RequestMapping(value = "/get/all",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Post> selectPostNormalAll(String status, Integer start, Integer count) {
        List<Post> postList = postService.selectPostNormalAll(status, start, count);
        return postList;
    }

    /**
     * 分页查询所有置顶/精华/推荐帖子，按发帖时间降序排列
     * @return
     */
    @RequestMapping(value = "/get/all/label",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Post> selectTopPost(String label, String status, Integer start, Integer count) {
        List<Post> postList = postService.selectLabelPostAll(label, status, start, count);
        return postList;
    }

    /**
     * 根据帖子ID精确查找帖子信息
     * @param postId
     * @return
     */
    @RequestMapping(value = "/get/by/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Post selectPostById(String postId) {
        Post post = postService.selectPostById(postId);
        return post;
    }

    /**
     * 根据版块ID和帖子状态查找版块下的所有帖子
     * @param boardId
     * @param status
     * @return
     */
    @RequestMapping(value = "/get/by/board/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Post> selectPostByBoardId(String boardId, String status, Integer start, Integer count) {
        List<Post> postList = postService.selectPostByBoardId(boardId, status, start, count);
        return postList;
    }

    /**
     * 根据用户ID和状态查询该用户发的所有帖子
     * @param userId
     * @param status
     * @return
     */
    @RequestMapping(value = "/get/by/initiate/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Post> selectPostByInitiateId(String userId, String status, Integer start, Integer count) {
        List<Post> postList = postService.selectPostByInitiateId(userId, status, start, count);
        return postList;
    }

    /**
     * 根据用户ID和状态查询该用户审核的所有帖子
     * @param userId
     * @param status
     * @return
     */
    @RequestMapping(value = "/get/by/audit/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Post> selectPostByAuditId(String userId, String status, Integer start, Integer count) {
        List<Post> postList = postService.selectPostByAuditId(userId, status, start, count);
        return postList;
    }

    /**
     * 根据用户ID查询该用户收藏的所有帖子
     * @param userId
     * @param status
     * @param start
     * @param count
     * @return
     */
    @RequestMapping(value = "/get/enshrine/by/user/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Post> selectEnshrinePostByUserId(String userId, String status, Integer start, Integer count) {
        List<Post> postList = postService.selectEnshrinePostByUserId(userId, status, start, count);
        return postList;
    }

    /**
     * 根据用户ID查询该用户访问过的帖子
     * @param userId
     * @param status
     * @param start
     * @param count
     * @return
     */
    @RequestMapping(value = "/get/visit/by/user/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Post> selectVisitPostByUserId(String userId, String status, Integer start, Integer count) {
        List<Post> postList = postService.selectVisitPostByUserId(userId, status, start, count);
        return postList;
    }

    /**
     * 查询论坛的今日发帖、昨日发帖、共发帖数目
     * @return
     */
    @RequestMapping(value = "/get/num",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Integer> selectPostSum() {
        Map<String, Integer> numMap = postService.selectPostNum();
        numMap.put("userNum", userService.selectUserNum("正常"));
        return numMap;
    }

    /**
     * 发布帖子
     * @param post
     * @return
     */
    @RequestMapping(value = "/post/post",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean insertPost(Post post) {

        Post newPost = new Post();
        newPost.setPostId(IDUtile.createId("帖子"));
        newPost.setTitle(post.getTitle());
        newPost.setBoardId(post.getBoardId());
        newPost.setInitiateId(post.getInitiateId());
        newPost.setContent(post.getContent());
        newPost.setPublishDate(IDUtile.getNewDate());
        newPost.setClick(0);
        newPost.setPraise(0);
        newPost.setDisagree(0);
        newPost.setComment(0);
        newPost.setRecommend(false);
        newPost.setTop(false);
        newPost.setElite(false);
        newPost.setStatus("审核中");
        newPost.setDeleteDate(null);
        int re = postService.insertPost(newPost);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 帖子审核通过
     * @param postId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/put/pass/post",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updatePassPost(String postId, String userId) {
        Post post = new Post();
        post.setPostId(postId);
        post.setAuditId(userId);
        post.setStatus("正常");
        int re = postService.updatePost(post);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改帖子
     * @param post
     * @return
     */
    @RequestMapping(value = "/put/post",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updatePost(Post post) {
        int re = postService.updatePost(post);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 软删除帖子
     * @param postId
     * @return
     */
    @RequestMapping(value = "/put/delete/post",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updateSoftPost(String postId) {
        int re = postService.updateSoftPost(postId, IDUtile.getNewDate());

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 硬删除帖子
     * @param postId
     * @return
     */
    @RequestMapping(value = "/delete/post",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean deleteStiffPost(String postId) {
        int re = postService.deleteStiffPost(postId);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }
}
