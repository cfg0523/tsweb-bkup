package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Component;
import com.techsen.tsweb.sys.domain.Operation;

@LocalMyBatisDao
public interface ComponentDao extends Dao<Component>{

    /**
     * 根据componentId获取Operation集合
     */
    public List<Operation> getOperationsByComponentId(String componentId);
    
}
