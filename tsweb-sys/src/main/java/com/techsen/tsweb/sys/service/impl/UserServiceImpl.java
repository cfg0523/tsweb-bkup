package com.techsen.tsweb.sys.service.impl;

import static com.techsen.tsweb.sys.util.SysConst.CACHE_AUTH;
import static com.techsen.tsweb.sys.util.SysConst.CACHE_ROLE;
import static com.techsen.tsweb.sys.util.SysConst.CACHE_USER;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

    @Override
    @Cacheable(value = CACHE_USER)
    public User getUser(String userId) {
        return this.userDao.getEntity(userId);
    }

    @Override
    @Cacheable(value = CACHE_USER)
    public User getUserByUsername(String username) {
        return this.userDao.getUserByUsername(username);
    }

    @Override
    public void addUser(User user) {
        this.userDao.addEntity(user);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_USER, key = "#user.id", beforeInvocation = true),
            @CacheEvict(value = CACHE_USER, key = "#user.username", beforeInvocation = true),
            @CacheEvict(value = CACHE_ROLE, key = "#user.id", beforeInvocation = true),
            @CacheEvict(value = CACHE_AUTH, key = "#user.id", beforeInvocation = true) })
    public void deleteUser(User user) {
        this.userDao.deleteEntity(user);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_USER, key = "#user.id", beforeInvocation = true),
            @CacheEvict(value = CACHE_USER, key = "#user.username", beforeInvocation = true) })
    public void updateUser(User user) {
        this.userDao.updateEntity(user);
    }
}
