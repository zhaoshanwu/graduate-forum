package com.sw.service;

import com.sw.entity.ParentBoard;
import com.sw.entity.combination.BoardName;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ParentBoardService {

    // 查询所有父版块
    public List<ParentBoard> selectParentBoardAll();

    // 根据帖子ID查询其版块及父版块名
    public BoardName selectParentBoardNameByPostId(String postId);

    // 根据父版块名查询父版块ID
    public String selectParentBoardByName(String parentBoardName);

    // 添加父版块对象
    public int insertParentBoard(ParentBoard parentBoard);

    // 修改父板块对象
    public int updateParentBoard(ParentBoard parentBoard);

    // 删除父版块对象
    public int deleteParentBoard(String parentBoardId);
}
