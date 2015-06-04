package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.AuthDao;
import com.techsen.tsweb.sys.dao.RoleDao;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;
import com.techsen.tsweb.sys.util.SysConst;

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
    @Caching(cacheable = {
            @Cacheable(value = SysConst.CACHE_USER, key = "#this.methodName.concat(':' + #user.id)", condition = "#user.id != null"),
            @Cacheable(value = SysConst.CACHE_USER, key = "#this.methodName.concat(':' + #user.username)", condition = "#user.username != null") })
    public User getUserByUser(User user) {
        User result = this.userDao.getUserByUser(user);
        return result;
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
        this.userDao.deleteEntity(user);
    }

}
