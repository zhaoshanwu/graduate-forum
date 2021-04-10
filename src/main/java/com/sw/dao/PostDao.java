package com.sw.dao;

import com.sw.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PostDao {

    // 获取所有该状态该标签帖子的数量
    public int selectPostCount(@Param("status") String status,
                               @Param("label") String label,
                               @Param("labelYN") Boolean labelYN);

    // 分页查询所有非置顶(正常，冻结，审核中，删除)帖子，按发帖时间降序排列
    public List<Post> selectPostNormalAll(@Param("status") String status,
                                       @Param("start") Integer start,
                                       @Param("count") Integer count);

    // 分页查询所有置顶/精华/推荐帖子，按发帖时间降序排列
    public List<Post> selectLabelPostAll(@Param("label") String label,
                                         @Param("status") String status,
                                         @Param("start") Integer start,
                                         @Param("count") Integer count);

    // 根据帖子ID查询帖子信息
    public Post selectPostById(@Param("postId") String postId);

    // 根据版块ID分页查询其下所有帖子信息
    public List<Post> selectPostByBoardId(@Param("boardId") String boardId,
                                          @Param("status") String status,
                                          @Param("start") Integer start,
                                          @Param("count") Integer count);

    // 根据用户ID分页查询该用户发的所有帖子信息
    public List<Post> selectPostByInitiateId(@Param("userId") String userId,
                                             @Param("status") String status,
                                             @Param("start") Integer start,
                                             @Param("count") Integer count);

    // 根据用户ID分页查询该用户审核过的所有帖子信息
    public List<Post> selectPostByAuditId(@Param("userId") String userId,
                                          @Param("status") String status,
                                          @Param("start") Integer start,
                                          @Param("count") Integer count);

    // 根据用户ID分页查询该用户收藏的所有帖子信息
    public List<Post> selectEnshrinePostByUserId(@Param("userId") String userId,
                                                 @Param("status") String status,
                                                 @Param("start") Integer start,
                                                 @Param("count") Integer count);

    // 根据用户ID分页查询该用户浏览过的所有帖子信息
    public List<Post> selectVisitPostByUserId(@Param("userId") String userId,
                                              @Param("status") String status,
                                              @Param("start") Integer start,
                                              @Param("count") Integer count);

    // 根据年月日条件查询帖子总数
    public int selectPostNum(@Param("publishDate") String publishDate, @Param("status") String status);

    // 添加帖子进行审核
    public int insertPost(Post post);

    // 修改帖子信息
    public int updatePost(Post post);

    // 软删除帖子
    public int updateSoftPost(@Param("postId") String postId, @Param("deleteDate") Timestamp deleteDate);

    // 硬删除帖子
    public int deleteStiffPost(@Param("postId") String postId);
}
