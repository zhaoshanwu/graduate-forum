package com.sw.service.impl;

import com.sw.dao.CreateIdDao;
import com.sw.entity.CreateId;
import com.sw.service.CreateIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CreateIdService")
public class CreateIdServiceImpl implements CreateIdService {

    @Autowired
    private CreateIdDao createIdDao;

    @Override
    public CreateId selectCreateId() {
        return createIdDao.selectCreateId();
    }

    @Override
    public void updateCreateId(CreateId createId) {
        createIdDao.updateCreateId(createId);
    }
}
