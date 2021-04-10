package com.sw.dao;

import com.sw.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    // 根据帖子ID和状态查询评论数
    public int selectCommentNumByPostId(@Param("postId") String postId,
                                        @Param("status") String status);

    // 根据帖子ID分页查询所有评论，按评论时间降序
    public List<Comment> selectCommentByPostId(@Param("postId") String postId,
                                          @Param("status") String status,
                                          @Param("start") Integer start,
                                          @Param("count") Integer count);

    // 根据用户ID分页查询该用户的所有评论，按评论时间降序
    public List<Comment> selectCommentByUserId(@Param("userId") String userId,
                                          @Param("status") String status,
                                          @Param("start") Integer start,
                                          @Param("count") Integer count);

    // 根据评论ID查询该评论所在帖子ID
    public String selectPostIdByCommentId(@Param("commentId") String commentId);

    // 根据评论对象添加评论
    public int insertComment(Comment comment);

    // 根据评论对象修改评论
    public int updateComment(Comment comment);

    // 根据评论ID删除评论
    public int deleteComment(@Param("commentId") String commentId);
}
