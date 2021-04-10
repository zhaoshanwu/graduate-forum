package com.sw.service.impl;

import com.sw.dao.BoardDao;
import com.sw.entity.Board;
import com.sw.entity.combination.BoardIdAndName;
import com.sw.service.BoardService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    @Override
    public Map<String, String> selectBoardIdAndName() {
        Map<String, String> boardMap = new HashMap<String, String>();
        List<BoardIdAndName> boardIdAndNameList = boardDao.selectBoardIdAndName();

        Iterator<BoardIdAndName> iterator = boardIdAndNameList.iterator();
        while (iterator.hasNext()) {
            BoardIdAndName boardIdAndName = iterator.next();
            boardMap.put(boardIdAndName.getBoardId(), boardIdAndName.getBoardName());
        }
        return boardMap;
    }

    @Override
    public List<Board> selectBoardByParentBoardId(String parentBoardId) {
        return boardDao.selectBoardByParentBoardId(parentBoardId);
    }

    @Override
    public String selectBoardByBoardName(String boardName) {
        return boardDao.selectBoardByBoardName(boardName);
    }

    @Override
    public List<Board> selectBoardByLikeBoardName(String boardName, String status, Integer start, Integer count) {
        StringBuffer boardNameStr = new StringBuffer();
        boardNameStr.append("%");
        boardNameStr.append(boardName);
        boardNameStr.append("%");
        return boardDao.selectBoardByLikeBoardName(boardNameStr.toString(), status, start, count);
    }

    @Override
    public Board selectBoardByUserId(String userId, String status, Integer start, Integer count) {
        return boardDao.selectBoardByUserId(userId, status, start, count);
    }

    @Override
    public int insertBoard(Board board) {
        return boardDao.insertBoard(board);
    }

    @Override
    public int updateBoard(Board board) {
        return boardDao.updateBoard(board);
    }

    @Override
    public int deleteBoard(String boardId) {
        return boardDao.deleteBoard(boardId);
    }
}
