package com.techsen.tsweb.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.AuthDao;
import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.AuthService;
import com.techsen.tsweb.sys.util.SysConst;

@Service("authService")
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthDao authDao;

    /**
     * 根据用户id或username获取Auths
     */
    @Override
    @Caching(cacheable = {
            @Cacheable(value = SysConst.CACHE_AUTH, key = "#this.methodName.concat(':' + #user.id)", condition = "#user.id != null"),
            @Cacheable(value = SysConst.CACHE_AUTH, key = "#this.methodName.concat(':' + #user.username)", condition = "#user.username != null") })
    public List<Auth> getAuthsByUser(User user) {
        return this.authDao.getAuthsByUser(user);
    }

}
