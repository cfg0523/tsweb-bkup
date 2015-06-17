package com.techsen.tsweb.sys.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        List<Permission> retVal = new ArrayList<Permission>();
        List<AclPermission> aclPermissions = this.aclService.getAclPermissionsByRoleName(roleName);
        for (AclPermission aclPermission : aclPermissions) {
            retVal.add(aclPermission);
        }
        return retVal;
    }

}
