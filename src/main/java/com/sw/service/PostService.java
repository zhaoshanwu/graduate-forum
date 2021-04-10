package com.sw.service;

import com.sw.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Transactional
public interface PostService {

    // 获取所有帖子的数量
    public int selectPostCount(String status, String label, Boolean labelYN);

    // 分页查询所有(正常，冻结，审核中，删除)帖子，按发帖时间降序排列
    public List<Post> selectPostNormalAll(String status, Integer start, Integer count);

    // 查询所有置顶帖子，按发帖时间降序排列
    public List<Post> selectLabelPostAll(String label, String status, Integer start, Integer count);

    // 根据帖子ID查询帖子信息
    public Post selectPostById(String postId);

    // 根据版块ID查询其下所有帖子信息
    public List<Post> selectPostByBoardId(String boardId, String status, Integer start, Integer count);

    // 根据用户ID查询该用户发的所有帖子信息
    public List<Post> selectPostByInitiateId(String userId, String status, Integer start, Integer count);

    // 根据用户ID查询该用户审核过的所有帖子信息
    public List<Post> selectPostByAuditId(String userId, String status, Integer start, Integer count);

    // 根据用户ID分页查询该用户收藏的所有帖子信息
    public List<Post> selectEnshrinePostByUserId(String userId, String status, Integer start, Integer count);

    // 根据用户ID分页查询该用户浏览过的所有帖子信息
    public List<Post> selectVisitPostByUserId(String userId, String status, Integer start, Integer count);

    // 查询帖子的今日发帖，昨日发帖，共有帖子数
    public Map<String, Integer> selectPostNum();

    // 添加帖子进行审核
    public int insertPost(Post post);

    // 修改帖子信息
    public int updatePost(Post post);

    // 软删除帖子
    public int updateSoftPost(String postId, Timestamp deleteDate);

    // 硬删除帖子
    public int deleteStiffPost(String postId);
}
