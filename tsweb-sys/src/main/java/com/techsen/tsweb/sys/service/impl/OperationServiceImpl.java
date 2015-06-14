package com.techsen.tsweb.sys.service.impl;

import com.techsen.tsweb.sys.dao.OperationDao;
import com.techsen.tsweb.sys.domain.Operation;
import com.techsen.tsweb.sys.service.OperationService;

public class OperationServiceImpl implements OperationService {

    private OperationDao operationDao;

    /**
     * 根据Operation的Id或name获取Operation
     */
    @Override
    public Operation getOperation(Operation operation) {
        return this.operationDao.getEntity(operation);
    }

    /**
     * 新增Operation
     */
    @Override
    public Operation addOperation(Operation operation) {
        this.operationDao.addEntity(operation);
        return operation;
    }

    /**
     * 修改Operation
     */
    @Override
    public void updateComponent(Operation operation) {
        this.operationDao.updateEntity(operation);
    }

    /**
     * 删除Operation
     */
    @Override
    public void deleteOperation(Operation operation) {
        this.operationDao.deleteEntity(operation);
    }
    
}
