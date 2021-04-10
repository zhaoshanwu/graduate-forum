package com.sw.service.impl;

import com.sw.dao.ParentBoardDao;
import com.sw.dao.BoardDao;
import com.sw.entity.Board;
import com.sw.entity.ParentBoard;
import com.sw.entity.combination.BoardName;
import com.sw.service.ParentBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ParentBoardService")
public class ParentBoardServiceImpl implements ParentBoardService {

    @Autowired
    private ParentBoardDao parentBoardDao;

    @Autowired
    private BoardDao boardDao;

    @Override
    public List<ParentBoard> selectParentBoardAll() {
        return parentBoardDao.selectParentBoardAll();
    }

    @Override
    public BoardName selectParentBoardNameByPostId(String postId) {
        return parentBoardDao.selectParentBoardNameByPostId(postId);
    }

    @Override
    public String selectParentBoardByName(String parentBoardName) {
        return parentBoardDao.selectParentBoardByName(parentBoardName);
    }

    @Override
    public int insertParentBoard(ParentBoard parentBoard) {
        return parentBoardDao.insertParentBoard(parentBoard);
    }

    @Override
    public int updateParentBoard(ParentBoard parentBoard) {
        return parentBoardDao.updateParentBoard(parentBoard);
    }

    @Override
    public int deleteParentBoard(String parentBoardId) {

        List<Board> boardList = boardDao.selectBoardByParentBoardId(parentBoardId);
        if (boardList.size() == 0) {
            return parentBoardDao.deleteParentBoard(parentBoardId);
        } else {
            return 0;
        }
    }
}
