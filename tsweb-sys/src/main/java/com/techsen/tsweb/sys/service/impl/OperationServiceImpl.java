package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.annotation.AuthComponent;
import com.techsen.tsweb.sys.annotation.AuthComponentType;
import com.techsen.tsweb.sys.annotation.AuthOperation;
import com.techsen.tsweb.sys.dao.OperationDao;
import com.techsen.tsweb.sys.domain.Operation;
import com.techsen.tsweb.sys.service.OperationService;

@Service("operationService")
@AuthComponent(name = "OperationService", desc = "组件操作资源服务", type = AuthComponentType.Service)
public class OperationServiceImpl implements OperationService {

    @Resource
    private OperationDao operationDao;

    /**
     * 根据Operation的Id或name获取Operation
     */
    @Override
    @AuthOperation(aclBit = 0x01, desc = "根据Operation的Id或name获取Operation")
    public Operation getOperation(Operation operation) {
        return this.operationDao.getEntity(operation);
    }

    /**
     * 新增Operation
     */
    @Override
    @AuthOperation(aclBit = 0x02, desc = "新增Operation")
    public Operation addOperation(Operation operation) {
        this.operationDao.addEntity(operation);
        return operation;
    }

    /**
     * 修改Operation
     */
    @Override
    @AuthOperation(aclBit = 0x03, desc = "修改Operation")
    public void updateComponent(Operation operation) {
        this.operationDao.updateEntity(operation);
    }

    /**
     * 删除Operation
     */
    @Override
    @AuthOperation(aclBit = 0x04, desc = "删除Operation")
    public void deleteOperation(Operation operation) {
        this.operationDao.deleteEntity(operation);
    }

    /**
     * 删除所有Operation
     */
    @Override
    @AuthOperation(aclBit = 0x05, desc = "删除所有Operation")
    public void removeAll() {
        this.operationDao.removeAll();
    }

}
