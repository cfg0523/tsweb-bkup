package com.techsen.tsweb.sys.dao;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Role;

@LocalMyBatisDao
public interface RoleDao extends Dao<Role> {
    /**
     * 根据角色Id或roleName获取Role
     */
    public Role getRoleByRole(Role role);
}
