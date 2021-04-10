package com.sw.service.impl;

import com.sw.dao.PostDao;
import com.sw.entity.Post;
import com.sw.service.PostService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("PostService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;


    @Override
    public int selectPostCount(String status, String label, Boolean labelYN) {
        if (label != null) {
            switch (label) {
                case "推荐":
                    label = "recommend";
                    break;
                case "置顶":
                    label = "top";
                    break;
                case "精华":
                    label = "elite";
                    break;
                default:
                    return 0;
            }
        }
        return postDao.selectPostCount(status, label, labelYN);
    }

    @Override
    public List<Post> selectPostNormalAll(String status, Integer start, Integer count) {
        return postDao.selectPostNormalAll(status, start, count);
    }

    @Override
    public List<Post> selectLabelPostAll(String label, String status, Integer start, Integer count) {
        if (label != null) {
            switch (label) {
                case "推荐":
                    label = "recommend";
                    break;
                case "置顶":
                    label = "top";
                    break;
                case "精华":
                    label = "elite";
                    break;
                default:
                    return null;
            }
        }
        return postDao.selectLabelPostAll(label, status, start, count);
    }

    @Override
    public Post selectPostById(String postId) {
        return postDao.selectPostById(postId);
    }

    @Override
    public List<Post> selectPostByBoardId(String boardId, String status, Integer start, Integer count) {
        return postDao.selectPostByBoardId(boardId, status, start, count);
    }

    @Override
    public List<Post> selectPostByInitiateId(String userId, String status, Integer start, Integer count) {
        return postDao.selectPostByInitiateId(userId, status, start, count);
    }

    @Override
    public List<Post> selectPostByAuditId(String userId, String status, Integer start, Integer count) {
        return postDao.selectPostByAuditId(userId, status, start, count);
    }

    @Override
    public List<Post> selectEnshrinePostByUserId(String userId, String status, Integer start, Integer count) {
        return postDao.selectEnshrinePostByUserId(userId, status, start, count);
    }

    @Override
    public List<Post> selectVisitPostByUserId(String userId, String status, Integer start, Integer count) {
        return postDao.selectVisitPostByUserId(userId, status, start, count);
    }

    @Override
    public Map<String, Integer> selectPostNum() {
        // 获取今天和昨天的时间
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate = new Date(System.currentTimeMillis());
        Date yesterdayDate = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);

        Integer todayNum = postDao.selectPostNum(sdf.format(todayDate),"正常");
        Integer yesterdayNum = postDao.selectPostNum(sdf.format(yesterdayDate), "正常");
        Integer postNum = postDao.selectPostNum(null, "正常");

        Map<String, Integer> sumMap = new HashMap<String, Integer>();
        sumMap.put("todayNum", todayNum);
        sumMap.put("yesterdayNum", yesterdayNum);
        sumMap.put("postNum", postNum);

        return sumMap;
    }

    @Override
    public int insertPost(Post post) {
        return postDao.insertPost(post);
    }

    @Override
    public int updatePost(Post post) {
        return postDao.updatePost(post);
    }

    @Override
    public int updateSoftPost(String postId, Timestamp deleteDate) {
        return postDao.updateSoftPost(postId, deleteDate);
    }

    @Override
    public int deleteStiffPost(String postId) {
        return postDao.deleteStiffPost(postId);
    }
}
