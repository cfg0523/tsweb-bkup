package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;

public interface RoleService {
    
    /**
     * 根据用户id或username获取Roles
     */
    public List<Role> getRolesByUser(User user);
    
}
