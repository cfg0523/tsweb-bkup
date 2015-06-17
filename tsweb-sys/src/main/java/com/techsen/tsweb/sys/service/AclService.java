package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.auth.AclPermission;
import com.techsen.tsweb.sys.domain.Acl;

public interface AclService extends Service<Acl> {

    /**
     * 根据角色名获取AclPermission集合
     */
    public List<AclPermission> getAclPermissionsByRoleName(String roleName);
    
    /**
     * 根据用户名获取AclPermission集合
     */
    public List<AclPermission> getAclPermissionsByUsername(String username);
}
