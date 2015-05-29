package com.techsen.tsweb.sys.service.impl;

import static com.techsen.tsweb.sys.util.SysConst.CACHE_AUTH;
import static com.techsen.tsweb.sys.util.SysConst.CACHE_ROLE;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.RoleDao;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    @Cacheable(value = CACHE_ROLE)
    public Role getRole(String roleId) {
        return this.roleDao.getEntity(roleId);
    }

    @Override
    @Cacheable(value = CACHE_ROLE)
    public Role getRoleByRoleName(String roleName) {
        return this.roleDao.getRoleByName(roleName);
    }

    @Override
    public void addRole(Role role) {
        this.roleDao.addEntity(role);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_ROLE, key = "#role.id", beforeInvocation = true),
            @CacheEvict(value = CACHE_ROLE, key = "#role.roleName", beforeInvocation = true),
            @CacheEvict(value = CACHE_AUTH, key = "#role.id", beforeInvocation = true) })
    public void deleteRole(Role role) {
        this.roleDao.deleteEntity(role);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_ROLE, key = "#role.id", beforeInvocation = true),
            @CacheEvict(value = CACHE_ROLE, key = "#role.roleName", beforeInvocation = true) })
    public void updateRole(Role role) {
        this.roleDao.updateEntity(role);
    }

    @Override
    public List<Role> getRolesByUserId(String userId) {
        return this.roleDao.getRolesByUserId(userId);
    }
}
