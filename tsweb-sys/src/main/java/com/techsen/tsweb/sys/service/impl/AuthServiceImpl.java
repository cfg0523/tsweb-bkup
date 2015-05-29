package com.techsen.tsweb.sys.service.impl;

import static com.techsen.tsweb.sys.util.SysConst.CACHE_AUTH;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.AuthDao;
import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.service.AuthService;

@Service("authService")
public class AuthServiceImpl implements AuthService {
    
    @Resource private AuthDao authDao;
    
    @Override
    @Cacheable(value = CACHE_AUTH)
    public Auth getAuth(String authId) {
        return this.authDao.getEntity(authId);
    }

    @Override
    @Cacheable(value = CACHE_AUTH)
    public Auth getAuthByAuthName(String authName) {
        return this.authDao.getAuthByName(authName);
    }

    @Override
    public void addAuth(Auth auth) {
        this.authDao.addEntity(auth);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_AUTH, key = "#auth.id", beforeInvocation = true),
            @CacheEvict(value = CACHE_AUTH, key = "#auth.authName", beforeInvocation = true) })
    public void deleteAuth(Auth auth) {
        this.authDao.deleteEntity(auth);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_AUTH, key = "#auth.id", beforeInvocation = true),
            @CacheEvict(value = CACHE_AUTH, key = "#auth.authName", beforeInvocation = true) })
    public void updateAuth(Auth auth) {
        this.authDao.updateEntity(auth);
    }

    @Override
    public List<Auth> getAuthsByRoleId(String roleId) {
        return this.authDao.getAuthsByRoleId(roleId);
    }
    
    @Override
    public List<Auth> getAuthsByUserId(String userId) {
        return this.authDao.getAuthsByUserId(userId);
    }
}
