package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Component;
import com.techsen.tsweb.sys.domain.Operation;

@LocalMyBatisDao
public interface ComponentDao extends Dao<Component>{

    /**
     * 根据组件Id获取所有组件的操作
     */
    public List<Operation> getOperationsByComponentId(String componentId);
    
    /**
     * 删除所有组件资源
     */
    public void removeAll();
}
