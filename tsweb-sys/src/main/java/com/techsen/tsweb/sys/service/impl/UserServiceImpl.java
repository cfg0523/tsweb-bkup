package com.techsen.tsweb.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.RoleDao;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.dao.UserRoleDao;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;
import com.techsen.tsweb.sys.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private RoleDao roleDao;

    @Resource
    private UserRoleDao userRoleDao;
    
    /**
     * 根据用户Id或username获取用户信息
     */
    @Override
    public User getUser(User user) {
        return this.userDao.getEntity(user);
    }

    /**
     * 新增用户
     */
    @Override
    public User addUser(User user) {
        this.userDao.addEntity(user);
        return user;
    }

    /**
     * 修改用户
     */
    @Override
    public void updateUser(User user) {
        this.userDao.updateEntity(user);
    }
    
    /**
     * 删除用户
     */
    @Override
    public void deleteUser(User user) {
        // 删除用户所拥有的角色
        this.deleteRolesByUser(user);
        // 删除用户对象
        this.userDao.deleteEntity(user);
    }

    /**
     * 给用户添加角色
     */
    @Override
    public UserRole addRole(UserRole userRole) {
        this.userRoleDao.addEntity(userRole);
        return userRole;
    }

    /**
     * 删除用户所包含的指定角色
     */
    @Override
    public void deleteRole(UserRole userRole) {
        this.userRoleDao.deleteEntity(userRole);
    }
    
    /**
     * 获取用户的角色
     */
    @Override
    public List<Role> getRolesByUser(User user) {
        return this.userRoleDao.getRolesByUser(user);
    }

    /**
     * 删除用户所有的角色
     */
    @Override
    public void deleteRolesByUser(User user) {
        this.userRoleDao.deleteRolesByUser(user);
    }

}
