package com.sw.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sw.entity.Comment;
import com.sw.service.CommentService;
import com.sw.utile.IDUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 根据帖子ID和状态查询评论数
     * @param postId
     * @param status
     * @return
     */
    @RequestMapping(value = "/get/num/post/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Integer selectCommentNumByPostId(String postId, String status) {
        return commentService.selectCommentNumByPostId(postId, status);
    }

    /**
     * 根据帖子ID分页查询该帖子下的所有评论，按评论时间降序排列
     * @param postId
     * @param status
     * @param start
     * @param count
     * @return
     */
    @RequestMapping(value = "/get/by/post/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Comment> selectCommentByPostId(String postId, String status, Integer start, Integer count) {
        String newStatus = (status == null ? "正常" : status);

        List<Comment> commentList = commentService.selectCommentByPostId(postId, status, start, count);
        return commentList;
    }

    /**
     * 根据用户ID查询该用户发过的所有评论信息
     * @param userId
     * @param status
     * @param start
     * @param count
     * @return
     */
    @RequestMapping(value = "/get/by/user/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Comment> selectCommentByUserId(String userId, String status, Integer start, Integer count) {
        String newStatus = (status == null ? "正常" : status);

        List<Comment> commentList = commentService.selectCommentByUserId(userId, status, start, count);
        return commentList;
    }

    /**
     * 添加评论
     * @return
     */
    @RequestMapping(value = "/insert/comment",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean insertComment(String postId, String userId, String content) {
        Comment newComment = new Comment();
        newComment.setCommentId(IDUtile.createId("评论"));
        newComment.setPostId(postId);
        newComment.setUserId(userId);
        newComment.setContent(content);
        newComment.setCommentDate(IDUtile.getNewDate());
        newComment.setPraise(0);
        newComment.setDisagree(0);
        newComment.setRevert(0);
        newComment.setStatus("正常");

        int re = commentService.insertComment(newComment);
        if (re == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改帖子
     * @param comment
     * @return
     */
    @RequestMapping(value = "/update/comment",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updateComment(Comment comment) {
        int re = commentService.updateComment(comment);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    @RequestMapping(value = "/delete/comment",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean deleteComment(String commentId) {
        int re = commentService.deleteComment(commentId);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }
}
