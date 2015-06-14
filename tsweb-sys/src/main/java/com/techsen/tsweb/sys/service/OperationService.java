package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.sys.domain.Operation;

public interface OperationService {
    
    /**
     * 根据Operation的Id或name获取Operation
     */
    public Operation getOperation(Operation operation);
    
    /**
     * 新增Operation
     */
    public Operation addOperation(Operation operation);
    
    /**
     * 修改Operation
     */
    public void updateComponent(Operation operation);
    
    /**
     * 删除Operation
     */
    public void deleteOperation(Operation operation);
    
}
