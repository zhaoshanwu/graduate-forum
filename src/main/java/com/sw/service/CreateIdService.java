package com.sw.service;

import com.sw.entity.CreateId;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CreateIdService {

    // 查询ID信息
    public CreateId selectCreateId();

    // 修改ID信息
    public void updateCreateId(CreateId createId);
}
