package com.sw.controller;

import com.sw.entity.Board;
import com.sw.service.BoardService;
import com.sw.utile.IDUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    /**
     * 获取所有子版块的ID和版块名用于发帖选择版块
     * @return
     */
    @RequestMapping(value = "/get/board/id/name",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, String> selectBoardIdAndName() {
        Map<String, String> boardMap = boardService.selectBoardIdAndName();

        return boardMap;
    }

    /**
     * 根据父版块ID查询其所有的子版块
     * @param parentBoardId
     * @return
     */
    @RequestMapping(value = "/get/parent/board/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Board> selectBoardByParentBoardId(String parentBoardId) {
         List<Board> boardList = boardService.selectBoardByParentBoardId(parentBoardId);
         return boardList;
    }

    /**
     * 根据版块名模糊查询符合要求的版块
     * @param boardName
     * @return
     */
    @RequestMapping(value = "/get/name",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Board> selectBoardByBoardName(String boardName, String status, Integer start, Integer count) {

        List<Board> boardList = boardService.selectBoardByLikeBoardName(boardName, status, start, count);
        return boardList;
    }

    /**
     * 根据用户ID查询其管理的版块
     * @param userId
     * @return
     */
    @RequestMapping(value = "/get/user/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Board selectBoardByUserId(String userId, String status, Integer start, Integer count) {

        Board board = boardService.selectBoardByUserId(userId, status, start, count);

        if (board == null) {
            return null;
        } else {
            return board;
        }
    }

    /**
     * 添加版块
     * @param board
     * @return
     */
    @RequestMapping(value = "/post/board",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean insertBoard(Board board) {

        String boardId = boardService.selectBoardByBoardName(board.getBoardName());
        if (boardId != null) {
            return false;
        }

        Board newBoard = new Board();
        newBoard.setBoardId(IDUtile.createId("版块"));
        newBoard.setParentBoardId(board.getParentBoardId());
        newBoard.setBoardName(board.getBoardName());
        newBoard.setUserId(board.getUserId());
        newBoard.setEstablishDate(IDUtile.getNewDate());
        newBoard.setRemark(board.getRemark());

        int re = boardService.insertBoard(newBoard);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据版块对象修改版块信息
     * 如果要修改的版块名已存在则无法修改
     * @param board
     * @return
     */
    @RequestMapping(value = "/put/board",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updateBoard(Board board) {

        String boardId = boardService.selectBoardByBoardName(board.getBoardName());
        if (boardId != null) {
            return false;
        }

        Board newBoard = new Board();
        newBoard.setBoardId(board.getBoardId());
        newBoard.setParentBoardId(board.getParentBoardId());
        newBoard.setBoardName(board.getBoardName());
        newBoard.setUserId(board.getUserId());
        newBoard.setRemark(board.getRemark());

        int re = boardService.updateBoard(newBoard);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除版块
     * @param boardId
     * @return
     */
    @RequestMapping(value = "/delete/board",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean deleteBoard(String boardId) {

        int re = boardService.deleteBoard(boardId);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }
}
