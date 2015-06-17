package com.techsen.tsweb.sys.service.impl;

import static com.techsen.tsweb.sys.util.AclUtil.convert;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.auth.AclPermission;
import com.techsen.tsweb.sys.dao.AclDao;
import com.techsen.tsweb.sys.domain.Acl;
import com.techsen.tsweb.sys.service.AclService;

@Service("aclService")
public class AclServiceImpl extends BaseService<Acl, AclDao> implements AclService {

    @Override
    @Resource
    public void setDao(AclDao dao) {
        this.dao = dao;
    }

    /**
     * 根据角色名获取AclPermission集合
     */
    @Override
    public List<AclPermission> getAclPermissionsByRoleName(String roleName) {
        return convert(this.dao.getAclsByRoleName(roleName));
    }

    /**
     * 根据用户名获取AclPermission集合
     */
    @Override
    public List<AclPermission> getAclPermissionsByUsername(String username) {
        return convert(this.dao.getAclsByUsername(username));
    }

}
