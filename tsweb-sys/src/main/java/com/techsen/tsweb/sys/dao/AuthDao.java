package com.techsen.tsweb.sys.dao;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Auth;

@LocalMyBatisDao
public interface AuthDao extends Dao<Auth>{
    /**
     * 根据权限Id或authName获取Auth
     */
    public Auth getAuthByAuth(Auth auth);
}
