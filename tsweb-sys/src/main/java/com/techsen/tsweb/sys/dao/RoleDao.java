package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;

@LocalMyBatisDao
public interface RoleDao extends Dao<Role> {
    /**
     * 根据角色Id或roleName获取Role
     */
    public Role getRoleByRole(Role role);
    
    /**
     * 根据用户Id或用户名获取Roles
     */
    public List<Role> getRolesByUser(User user);
}
