package com.sw.controller;

import com.sw.entity.Revert;
import com.sw.service.RevertService;
import com.sw.utile.IDUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.server.InactiveGroupException;

import java.util.List;

@Controller
@RequestMapping("/revert")
public class RevertController {

    @Autowired
    private RevertService revertService;

    /**
     * 根据评论ID分页查询该评论下所有回复
     * @param commentId
     * @param status
     * @param start
     * @param count
     * @return
     */
    @RequestMapping(value = "/get/by/comment/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Revert> selectRevertByCommentId(String commentId, String status, Integer start, Integer count) {
        List<Revert> revertList = revertService.selectRevertByCommentId(commentId, status, start, count);
        return revertList;
    }

    /**
     * 根据用户ID分页查询该用户的所有回复
     * @param userId
     * @param status
     * @param start
     * @param count
     * @return
     */
    @RequestMapping(value = "/get/by/user/id",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Revert> selectRevertByUserId(String userId, String status, Integer start, Integer count) {
        List<Revert> revertList = revertService.selectRevertByUserId(userId, status, start, count);

        return revertList;
    }

    /**
     * 添加回复
     * @param revert
     * @return
     */
    @RequestMapping(value = "/insert/revert",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean insertRevert(Revert revert) {
        Revert newRevert = new Revert();
        newRevert.setRevertId(IDUtile.createId("回复"));
        newRevert.setCommentId(revert.getCommentId());
        newRevert.setUserId(revert.getUserId());
        newRevert.setContent(revert.getContent());
        newRevert.setRevertDate(IDUtile.getNewDate());
        newRevert.setPraise(0);
        newRevert.setDisagree(0);
        newRevert.setStatus("正常");

        int re = revertService.insertRevert(newRevert);

        if (re == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改回复的点赞数和踩数
     * @param revert
     * @return
     */
    @RequestMapping(value = "/update/revert",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updateRevert(Revert revert) {
        int re = revertService.updateRevert(revert);

        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除回复
     * @param revertId
     * @return
     */
    @RequestMapping(value = "/delete/revert",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean deleteRevert(String revertId) {
        int re = revertService.deleteRevert(revertId);

        if (re == 2) {
            return true;
        } else {
            return false;
        }
    }
}
