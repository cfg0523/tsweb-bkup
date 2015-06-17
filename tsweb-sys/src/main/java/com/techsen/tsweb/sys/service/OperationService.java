package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.domain.Operation;

public interface OperationService extends Service<Operation>{

    /**
     * 根据组件类型、组件名、组件的操作名获取Operation
     */
    public Operation getOperationByComponentAndOperationName(String componentType, String componentName, String operationName);
    
    /**
     * 删除所有操作资源
     */
    public void removeAll();
    
}
