package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.AuthDao;
import com.techsen.tsweb.sys.dao.RoleDao;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private RoleDao roleDao;

    @Resource
    private AuthDao authDao;

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
    public void addUser(User user) {
        this.userDao.addEntity(user);
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
        // 删除用户对象
        this.userDao.deleteEntity(user);
        // 删除用户所拥有的角色对象
        this.userDao.deleteRolesByUser(user);
    }

}
