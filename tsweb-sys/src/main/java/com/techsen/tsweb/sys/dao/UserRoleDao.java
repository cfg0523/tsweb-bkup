package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;

@LocalMyBatisDao
public interface UserRoleDao extends Dao<UserRole> {

    /**
     * 根据用户删除用户的角色<br/>
     * 根据User删除User和Role的关联关系
     */
    public void deleteRolesByUser(User user);
    
    /**
     * 根据用户Id或用户名获取Roles
     */
    public List<Role> getRolesByUser(User user);
}
