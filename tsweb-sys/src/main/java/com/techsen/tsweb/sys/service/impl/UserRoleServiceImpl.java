package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.UserRoleDao;
import com.techsen.tsweb.sys.domain.UserRole;
import com.techsen.tsweb.sys.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl extends BaseService<UserRole, UserRoleDao> implements UserRoleService{

    @Override
    @Resource
    public void setDao(UserRoleDao userRoleDao) {
        this.dao = userRoleDao;
    }
    
}
