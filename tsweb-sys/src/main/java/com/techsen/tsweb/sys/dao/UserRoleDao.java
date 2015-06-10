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
     * 根据用户Id或用户名获取Roles
     */
    public List<Role> getRolesByUser(User user);
    
    /**
     * 删除用户所有的角色
     */
    public void deleteRolesByUser(User user);
    
    /**
     * 根据角色获取用户集合
     */
    public List<User> getUsersByRole(Role role);
    
    /**
     * 根据角色删除用户关联
     */
    public void deleteUsersByRole(Role role);
}
