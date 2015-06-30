package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.domain.Role;

public interface RoleService extends Service<Role> {

    public List<Role> getAllRoles();
    
}
