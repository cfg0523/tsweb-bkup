package com.techsen.tsweb.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.RoleDao;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.RoleService;
import com.techsen.tsweb.sys.util.SysConst;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private UserDao userDao;
    
    /**
     * 根据用户id或username获取Roles
     */
    @Override
    @Caching(cacheable = {
            @Cacheable(value = SysConst.CACHE_ROLE, key = "#user.id", condition = "#user.id != null"),
            @Cacheable(value = SysConst.CACHE_ROLE, key = "#user.username", condition = "#user.username != null") })
    public List<Role> getRolesByUser(User user) {
        return this.roleDao.getRolesByUser(user);
    }

}
