package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Role;

@LocalMyBatisDao
public interface RoleDao extends Dao<Role> {

    List<Role> getAllRoles();
    
}
