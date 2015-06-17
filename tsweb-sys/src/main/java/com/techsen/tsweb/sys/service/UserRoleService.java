package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;

public interface UserRoleService extends Service<UserRole> {

    /**
     * 根据用户获取用户的角色
     */
    public List<Role> getRolesByUser(User user);
    
}
