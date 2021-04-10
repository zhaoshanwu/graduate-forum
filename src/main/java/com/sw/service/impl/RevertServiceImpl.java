package com.sw.service.impl;

import com.sw.dao.CommentDao;
import com.sw.dao.RevertDao;
import com.sw.entity.Comment;
import com.sw.entity.Revert;
import com.sw.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RevertService")
public class RevertServiceImpl implements RevertService {

    @Autowired
    private RevertDao revertDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Revert> selectRevertByCommentId(String commentId, String status, Integer start, Integer count) {
        return revertDao.selectRevertByCommentId(commentId, status, start, count);
    }

    @Override
    public List<Revert> selectRevertByUserId(String userId, String status, Integer start, Integer count) {
        return revertDao.selectRevertByUserId(userId, status, start, count);
    }

    @Override
    public int insertRevert(Revert revert) {
        Comment comment = new Comment();
        comment.setCommentId(revertDao.selectCommentIdByRevertId(revert.getCommentId()));
        comment.setRevert(1);

        return revertDao.insertRevert(revert) + commentDao.updateComment(comment);
    }

    @Override
    public int updateRevert(Revert revert) {
        return revertDao.updateRevert(revert);
    }

    @Override
    public int deleteRevert(String revertId) {
        Comment comment = new Comment();
        comment.setCommentId(revertDao.selectCommentIdByRevertId(revertId));
        comment.setRevert(-1);

        return revertDao.deleteRevert(revertId) + commentDao.updateComment(comment);
    }
}
