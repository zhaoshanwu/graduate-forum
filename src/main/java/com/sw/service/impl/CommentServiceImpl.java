package com.sw.service.impl;

import com.sw.dao.CommentDao;
import com.sw.entity.Comment;
import com.sw.entity.Post;
import com.sw.service.CommentService;
import com.sw.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private PostService postService;

    @Override
    public int selectCommentNumByPostId(String postId, String status) {
        return commentDao.selectCommentNumByPostId(postId, status);
    }

    @Override
    public List<Comment> selectCommentByPostId(String postId, String status, Integer start, Integer count) {
        return commentDao.selectCommentByPostId(postId, status, start, count);
    }

    @Override
    public List<Comment> selectCommentByUserId(String userId, String status, Integer start, Integer count) {
        return commentDao.selectCommentByUserId(userId, status, start, count);
    }

    @Override
    public int insertComment(Comment comment) {
        Post post = new Post();
        post.setPostId(comment.getPostId());
        post.setComment(1);

        int re1 = commentDao.insertComment(comment);
        int re2 = postService.updatePost(post);

        return re1 + re2;
    }

    @Override
    public int updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public int deleteComment(String commentId) {

        Post post = new Post();
        post.setPostId(commentDao.selectPostIdByCommentId(commentId));
        post.setComment(-1);
        return commentDao.deleteComment(commentId) + postService.updatePost(post);
    }
}
