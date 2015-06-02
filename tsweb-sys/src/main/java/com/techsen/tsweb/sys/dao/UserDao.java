package com.techsen.tsweb.sys.dao;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.User;

@LocalMyBatisDao
public interface UserDao extends Dao<User> {
    /**
     * 根据用户的用户Id或username获取用户信息
     */
    User getUserByUser(User user);
}
