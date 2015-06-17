package com.techsen.tsweb.sys.dao;

import org.apache.ibatis.annotations.Param;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Operation;

@LocalMyBatisDao
public interface OperationDao extends Dao<Operation> {

    /**
     * 根据组件类型、组件名、组件的操作名获取Operation
     */
    public Operation getOperationByComponentAndOperationName(
            @Param("componentType") String componentType,
            @Param("componentName") String componentName,
            @Param("operationName") String operationName);

    /**
     * 删除所有操作资源
     */
    public void removeAll();
}
