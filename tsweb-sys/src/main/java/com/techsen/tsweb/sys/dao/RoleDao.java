package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Role;

public interface RoleDao extends Dao<Role> {
    Role getRoleByName(String roleName);
    List<Role> getRolesByUserId(String username);
}
