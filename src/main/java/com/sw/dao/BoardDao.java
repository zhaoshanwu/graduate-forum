package com.sw.dao;

import com.sw.entity.Board;
import com.sw.entity.combination.BoardIdAndName;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BoardDao {

    // 查询所有子版块ID及版块名
    public List<BoardIdAndName> selectBoardIdAndName();

    // 根据父版块ID查询所有子版块信息
    public List<Board> selectBoardByParentBoardId(@Param("parentBoardId") String parentBoardId);

    // 根据版块名查询版块信息
    public String selectBoardByBoardName(@Param("boardName") String boardName);

    // 根据版块名分页模糊查询版块信息
    public List<Board> selectBoardByLikeBoardName(@Param("boardName") String boardName,
                                                  @Param("status") String status,
                                                  @Param("start") Integer start,
                                                  @Param("count") Integer count);

    // 根据用户ID分页查询其管理的版块
    public Board selectBoardByUserId(@Param("userId") String userId,
                                     @Param("status") String status,
                                     @Param("start") Integer start,
                                     @Param("count") Integer count);

    // 根据用户ID分页查询其关注的版块
    public List<Board> selectAttentionBoardByUserId(@Param("userId") String userId,
                                                    @Param("status") String status,
                                                    @Param("start") Integer start,
                                                    @Param("count") Integer count);

    // 根据版块对象添加版块信息
    public int insertBoard(Board board);

    // 根据版块对象修改版块信息
    public int updateBoard(Board board);

    // 删除版块信息
    public int deleteBoard(@Param("boardId") String boardId);
}
