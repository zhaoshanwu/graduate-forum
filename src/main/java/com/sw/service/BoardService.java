package com.sw.service;

import com.sw.entity.Board;
import com.sw.entity.combination.BoardIdAndName;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface BoardService {

    // 查询所有子版块ID及版块名
    public Map<String, String> selectBoardIdAndName();

    // 根据父版块ID查询所有子版块信息
    public List<Board> selectBoardByParentBoardId(String parentBoardId);

    // 根据版块名查询版块信息
    public String selectBoardByBoardName(String boardName);

    // 根据版块名模糊查询版块信息
    public List<Board> selectBoardByLikeBoardName(String userId, String status, Integer start, Integer count);

    // 根据用户ID查询其管理的版块
    public Board selectBoardByUserId(String userId, String status, Integer start, Integer count);

    // 根据版块对象添加版块信息
    public int insertBoard(Board board);

    // 根据版块对象修改版块信息
    public int updateBoard(Board board);

    // 删除版块信息
    public int deleteBoard(String boardId);
}
