package com.techsen.tsweb.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.annotation.AuthComponent;
import com.techsen.tsweb.sys.annotation.AuthComponentType;
import com.techsen.tsweb.sys.annotation.AuthOperation;
import com.techsen.tsweb.sys.dao.RoleDao;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.dao.UserRoleDao;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;
import com.techsen.tsweb.sys.service.UserService;

@Service("userService")
@AuthComponent(name = "UserService", desc = "用户操作服务", type = AuthComponentType.Service)
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
    @AuthOperation(aclBit = 0x01, desc = "根据用户Id或username获取User")
    public User getUser(User user) {
        return this.userDao.getEntity(user);
    }

    /**
     * 新增用户
     */
    @Override
    @AuthOperation(aclBit = 0x02, desc = "新增用户")
    public User addUser(User user) {
        this.userDao.addEntity(user);
        return user;
    }

    /**
     * 修改用户
     */
    @Override
    @AuthOperation(aclBit = 0x03, desc = "修改用户信息")
    public void updateUser(User user) {
        this.userDao.updateEntity(user);
    }

    /**
     * 删除用户
     */
    @Override
    @AuthOperation(aclBit = 0x04, desc = "删除用户")
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
    @AuthOperation(aclBit = 0x05, desc = "给用户添加角色")
    public UserRole addRole(UserRole userRole) {
        this.userRoleDao.addEntity(userRole);
        return userRole;
    }

    /**
     * 删除用户所包含的指定角色
     */
    @Override
    @AuthOperation(aclBit = 0x06, desc = "删除用户所包含的指定角色")
    public void deleteRole(UserRole userRole) {
        this.userRoleDao.deleteEntity(userRole);
    }

    /**
     * 获取用户的角色集合
     */
    @Override
    @AuthOperation(aclBit = 0x07, desc = "获取用户的角色集合")
    public List<Role> getRolesByUser(User user) {
        return this.userRoleDao.getRolesByUser(user);
    }

    /**
     * 删除用户所有的角色
     */
    @Override
    @AuthOperation(aclBit = 0x08, desc = "删除用户所有的角色")
    public void deleteRolesByUser(User user) {
        this.userRoleDao.deleteRolesByUser(user);
    }

}
