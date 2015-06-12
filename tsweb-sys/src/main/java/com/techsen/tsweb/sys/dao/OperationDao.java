package com.techsen.tsweb.sys.dao;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Component;
import com.techsen.tsweb.sys.domain.Operation;

@LocalMyBatisDao
public interface OperationDao extends Dao<Operation>{

    /**
     * 根据Operation的componentId获取Component
     */
    public Component getComponentByComponentId(String componentId);
    
}
