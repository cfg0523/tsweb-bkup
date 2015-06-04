package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.domain.User;

@LocalMyBatisDao
public interface AuthDao extends Dao<Auth>{
    /**
     * 根据用户Id或userName获取Roles
     */
    public List<Auth> getAuthsByUser(User user);
}
