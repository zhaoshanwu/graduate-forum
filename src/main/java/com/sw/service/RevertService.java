package com.sw.service;

import com.sw.entity.Comment;
import com.sw.entity.Revert;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RevertService {

    // 根据评论ID分页查询该评论下的所有回复
    public List<Revert> selectRevertByCommentId(String commentId, String status, Integer start, Integer count);

    // 根据用户ID分页查询该用户的所有回复
    public List<Revert> selectRevertByUserId(String userId, String status, Integer start, Integer count);

    // 添加回复
    public int insertRevert(Revert revert);

    // 修改回复
    public int updateRevert(Revert revert);

    // 删除回复
    public int deleteRevert(String revertId);
}
