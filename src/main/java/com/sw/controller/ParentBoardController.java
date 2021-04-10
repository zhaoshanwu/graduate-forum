package com.sw.controller;

import com.sw.entity.Board;
import com.sw.entity.ParentBoard;
import com.sw.entity.combination.BoardName;
import com.sw.service.ParentBoardService;
import com.sw.utile.IDUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/parent/board")
public class ParentBoardController {

    @Autowired
    private ParentBoardService parentBoardService;

    /**
     * 查询所有父版块信息
     * @return
     */
    @RequestMapping(value = "/get/all",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<ParentBoard> selectParentBoardAll() {
        List<ParentBoard> parentBoardList = parentBoardService.selectParentBoardAll();
        return parentBoardList;
    }

    /**
     * 根据帖子ID查询该帖子所在版块名及父版块名
     * @param postId
     * @return
     */
    @RequestMapping(value = "/get/name/by/post/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BoardName selectParentBoardNameByPostId(String postId) {
        BoardName boardName = parentBoardService.selectParentBoardNameByPostId(postId);
        return boardName;
    }

    /**
     * 添加父版块
     * 如果父版块名重复则无法添加
     * @param parentBoard
     * @return
     */
    @RequestMapping(value = "/post/parent/board",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean insertParentBoard(ParentBoard parentBoard) {

        String parentBoardName = parentBoardService.selectParentBoardByName(parentBoard.getParentBoardName());
        if (parentBoardName != null) {
            return false;
        }

        ParentBoard newParentBoard = new ParentBoard();
        newParentBoard.setParentBoardId(IDUtile.createId("父版块"));
        newParentBoard.setParentBoardName(parentBoard.getParentBoardName());
        newParentBoard.setParentBoardDate(IDUtile.getNewDate());
        newParentBoard.setRemark(parentBoard.getRemark());

        int re = parentBoardService.insertParentBoard(newParentBoard);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改父版块信息
     * @param parentBoard
     * @return
     */
    @RequestMapping(value = "/put/parent/board",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updateParentBoard(ParentBoard parentBoard) {

        ParentBoard newParentBoard = new ParentBoard();
        newParentBoard.setParentBoardId(parentBoard.getParentBoardId());
        newParentBoard.setParentBoardName(parentBoard.getParentBoardName());
        newParentBoard.setRemark(parentBoard.getRemark());

        int re = parentBoardService.updateParentBoard(parentBoard);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除父版块
     * @param parentBoardId
     * @return
     */
    @RequestMapping(value = "/delete/parent/board",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean deleteParentBoard(String parentBoardId) {
        int re = parentBoardService.deleteParentBoard(parentBoardId);
        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }
}
