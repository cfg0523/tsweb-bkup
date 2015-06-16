package com.techsen.tsweb.sys.auth;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.springframework.stereotype.Component;

import com.techsen.tsweb.sys.service.AclService;

@Component("aclRolePermissionResolver")
public class AclRolePermissionResolver implements RolePermissionResolver {

    @Resource
    private AclService aclService;
    
    @Override
    public Collection<Permission> resolvePermissionsInRole(String roleName) {
        return this.aclService.getAclPermissionsByRoleName(roleName);
    }

}
