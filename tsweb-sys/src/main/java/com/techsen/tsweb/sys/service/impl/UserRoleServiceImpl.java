package com.techsen.tsweb.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.UserRoleDao;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;
import com.techsen.tsweb.sys.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl extends BaseService<UserRole, UserRoleDao> implements UserRoleService{

    @Override
    @Resource
    public void setDao(UserRoleDao dao) {
        this.dao = dao;
    }

    /**
     * 根据用户获取用户的角色
     */
    @Override
    public List<Role> getRolesByUser(User user) {
        return this.dao.getRolesByUser(user);
    }
    
}
