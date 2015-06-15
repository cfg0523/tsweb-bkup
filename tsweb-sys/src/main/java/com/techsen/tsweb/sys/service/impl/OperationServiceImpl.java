package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.OperationDao;
import com.techsen.tsweb.sys.domain.Operation;
import com.techsen.tsweb.sys.service.OperationService;

@Service("operationService")
public class OperationServiceImpl implements OperationService {

    @Resource
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

    /**
     * 删除所有Operation
     */
    @Override
    public void removeAll() {
        this.operationDao.removeAll();
    }
    
}
