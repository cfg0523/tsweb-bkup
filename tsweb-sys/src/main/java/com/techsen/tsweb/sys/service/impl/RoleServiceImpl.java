package com.techsen.tsweb.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.auth.AuthComponentType;
import com.techsen.tsweb.sys.auth.annotation.AuthComponent;
import com.techsen.tsweb.sys.auth.annotation.AuthOperation;
import com.techsen.tsweb.sys.dao.RoleDao;
import com.techsen.tsweb.sys.dao.UserRoleDao;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;
import com.techsen.tsweb.sys.service.RoleService;

@Service("roleService")
@AuthComponent(name = "RoleService", desc = "角色操作服务", type = AuthComponentType.Service)
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private UserRoleDao userRoleDao;

    /**
     * 根据角色Id或角色名获取Role
     */
    @AuthOperation(aclBit = 0x01, desc = "根据角色Id或角色名获取Role")
    @Override
    public Role getRole(Role role) {
        return this.roleDao.getEntity(role);
    }

    /**
     * 新增角色
     */
    @AuthOperation(aclBit = 0x02, desc = "新增角色")
    @Override
    public Role addRole(Role role) {
        this.roleDao.addEntity(role);
        return role;
    }

    /**
     * 修改角色
     */
    @AuthOperation(aclBit = 0x03, desc = "修改角色")
    @Override
    public void updateRole(Role role) {
        this.roleDao.updateEntity(role);
    }

    /**
     * 删除角色
     */
    @AuthOperation(aclBit = 0x04, desc = "删除角色")
    @Override
    public void deleteRole(Role role) {
        // 删除该角色所拥有的用户关联
        this.deleteUsersByRole(role);
        // 删除角色对象
        this.roleDao.deleteEntity(role);
    }

    /**
     * 给角色添加用户
     */
    @AuthOperation(aclBit = 0x05, desc = "给角色添加用户")
    @Override
    public UserRole addUser(UserRole userRole) {
        this.userRoleDao.addEntity(userRole);
        return userRole;
    }

    /**
     * 删除角色所包含的指定用户
     */
    @AuthOperation(aclBit = 0x06, desc = "删除角色所包含的指定用户")
    @Override
    public void deleteUser(UserRole userRole) {
        this.userRoleDao.deleteEntity(userRole);
    }

    /**
     * 根据角色获取用户集合
     */
    @AuthOperation(aclBit = 0x07, desc = "根据角色获取用户集合")
    @Override
    public List<User> getUsersByRole(Role role) {
        return this.userRoleDao.getUsersByRole(role);
    }

    /**
     * 删除角色中所有的用户
     */
    @AuthOperation(aclBit = 0x08, desc = "删除角色中所有的用户")
    @Override
    public void deleteUsersByRole(Role role) {
        this.userRoleDao.deleteUsersByRole(role);
    }

}
