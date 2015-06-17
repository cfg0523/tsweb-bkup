package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.RoleDao;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseService<Role, RoleDao> implements RoleService {

    @Override
    @Resource
    public void setDao(RoleDao roleDao) {
        this.dao = roleDao;
    }

}
