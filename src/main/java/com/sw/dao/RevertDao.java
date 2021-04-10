package com.sw.dao;

import com.sw.entity.Comment;
import com.sw.entity.Revert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevertDao {

    // 根据评论ID分页查询该评论下的所有回复
    public List<Revert> selectRevertByCommentId(@Param("commentId") String commentId,
                                                @Param("status") String status,
                                                @Param("start") Integer start,
                                                @Param("count") Integer count);

    // 根据用户ID分页查询该用户的所有回复
    public List<Revert> selectRevertByUserId(@Param("userId") String userId,
                                               @Param("status") String status,
                                               @Param("start") Integer start,
                                               @Param("count") Integer count);

    // 根据回复ID查询该回复所在评论ID
    public String selectCommentIdByRevertId(@Param("revertId") String revertId);

    // 添加回复
    public int insertRevert(Revert revert);

    // 修改回复
    public int updateRevert(Revert revert);

    // 删除回复
    public int deleteRevert(@Param("revertId") String revertId);
}
