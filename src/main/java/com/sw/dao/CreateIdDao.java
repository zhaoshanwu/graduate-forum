package com.sw.dao;

import com.sw.entity.CreateId;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateIdDao {

    // 查询ID信息
    public CreateId selectCreateId();
    // 修改ID信息
    public void updateCreateId(CreateId createId);
}
