package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;

public interface RoleService {
    /**
     * 根据角色Id或角色名获取Role
     */
    public Role getRole(Role role);
    
    /**
     * 新增角色
     */
    public Role addRole(Role role);
    
    /**
     * 修改角色
     */
    public void updateRole(Role role);
    
    /**
     * 删除角色
     */
    public void deleteRole(Role role);
    
    /**
     * 给角色添加用户
     */
    public UserRole addUser(UserRole userRole);
    
    /**
     * 删除指定的用户角色关联
     */
    public void deleteUser(UserRole userRole);
    
    /**
     * 根据角色获取用户集合
     */
    public List<User> getUsersByRole(Role role);
    
    /**
     * 删除角色中所有的用户
     */
    public void deleteUsersByRole(Role role);
    
}
