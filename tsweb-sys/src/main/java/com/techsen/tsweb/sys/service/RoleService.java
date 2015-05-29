package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.sys.domain.Role;

public interface RoleService {
    
    /**
     * 根据roleId获取Role
     */
    Role getRole(String roleId);
    
    /**
     * 根据roleName获取Role
     */
    Role getRoleByRoleName(String roleName);
    
    /**
     * 添加Role
     */
    void addRole(Role role);
    
    /**
     * 根据roleId删除Role
     */
    void deleteRole(Role role);
    
    /**
     * 根据roleId修改Role
     */
    void updateRole(Role role);
    
    /**
     * 根据userId获取用户的所有Role
     */
    List<Role> getRolesByUserId(String userId);
    
}
