package com.sw.service;

import com.sw.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CommentService {

    // 根据帖子ID和状态查询评论数
    public int selectCommentNumByPostId(String postId, String status);

    // 根据帖子ID分页查询所有评论，按评论时间降序
    public List<Comment> selectCommentByPostId(String postId, String status, Integer start, Integer count);

    // 根据用户ID分页查询该用户的所有评论，按评论时间降序
    public List<Comment> selectCommentByUserId(String userId, String status, Integer start, Integer count);

    // 根据评论对象添加评论
    public int insertComment(Comment comment);

    // 根据评论对象修改评论
    public int updateComment(Comment comment);

    // 根据评论ID删除评论
    public int deleteComment(String commentId);
}
