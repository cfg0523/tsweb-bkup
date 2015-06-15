package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;

public interface UserService {

    /**
     * 根据用户Id或username获取User
     */
    public User getUser(User user);

    /**
     * 新增用户
     */
    public User addUser(User user);

    /**
     * 修改用户
     */
    public void updateUser(User user);

    /**
     * 删除用户
     */
    public void deleteUser(User user);

    /**
     * 给用户添加角色关联
     */
    public UserRole addRole(UserRole userRole);

    /**
     * 删除用户所包含的指定角色
     */
    public void deleteRole(UserRole userRole);

    /**
     * 根据用户获取角色集合
     */
    public List<Role> getRolesByUser(User user);

    /**
     * 删除用户所有的角色
     */
    public void deleteRolesByUser(User user);

}
