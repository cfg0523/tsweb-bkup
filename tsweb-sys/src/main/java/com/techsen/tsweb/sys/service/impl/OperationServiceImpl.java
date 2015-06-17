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

    /**
     * 根据组件类型、组件名、组件的操作名获取Operation
     */
    public Operation getOperationByComponentAndOperationName(
            String componentType, String componentName, String operationName) {
        return this.dao.getOperationByComponentAndOperationName(componentType, componentName, operationName);
    }

    /**
     * 删除所有操作资源
     */
    @Override
    public void removeAll() {
        this.dao.removeAll();
    }

}
