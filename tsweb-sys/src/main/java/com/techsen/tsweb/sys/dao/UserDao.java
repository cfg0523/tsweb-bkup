package com.techsen.tsweb.sys.dao;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.User;

@LocalMyBatisDao
public interface UserDao extends Dao<User> {

    /**
     * 根据username查找用户
     */
    User getUserByUsername(String username);
}
