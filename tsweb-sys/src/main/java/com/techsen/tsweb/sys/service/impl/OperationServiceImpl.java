package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.OperationDao;
import com.techsen.tsweb.sys.domain.Operation;
import com.techsen.tsweb.sys.service.OperationService;

@Service("operationService")
public class OperationServiceImpl extends BaseService<Operation, OperationDao>
        implements OperationService {

    @Override
    @Resource
    public void setDao(OperationDao dao) {
        this.dao = dao;
    }

}
