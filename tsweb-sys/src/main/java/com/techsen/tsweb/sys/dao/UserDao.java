package com.techsen.tsweb.sys.dao;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.User;

@LocalMyBatisDao
public interface UserDao extends Dao<User> {
    
    /**
     * 根据用户删除用户的角色<br/>
     * 根据User删除User和Role的关联关系
     */
    public void deleteRolesByUser(User user);
}