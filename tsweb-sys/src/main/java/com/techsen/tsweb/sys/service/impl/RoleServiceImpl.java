package com.techsen.tsweb.sys.service.impl;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.RoleDao;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseService<Role, RoleDao> implements RoleService {

}
