package com.techsen.tsweb.sys.auth;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.springframework.stereotype.Component;

@Component("aclPermissionResolver")
public class AclPermissionResolver implements PermissionResolver {

    @Override
    public Permission resolvePermission(String permissionString) {
        return new AclPermission(permissionString);
    }

}
