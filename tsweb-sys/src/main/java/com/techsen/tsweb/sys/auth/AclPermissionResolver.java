package com.techsen.tsweb.sys.auth;

import static com.techsen.tsweb.core.util.ValidUtil.isNull;

import javax.annotation.Resource;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.springframework.stereotype.Component;

import com.techsen.tsweb.sys.domain.Operation;
import com.techsen.tsweb.sys.service.OperationService;

@Component("aclPermissionResolver")
public class AclPermissionResolver implements PermissionResolver {

    @Resource
    private OperationService operationService;

    @Override
    public Permission resolvePermission(String permissionString) {
        String resourceType = "*";
        String resourceName = "*";
        int aclCode = 0xFFFFFFFF;
        String operationName = "";
        String[] arr = permissionString.split(":");
        if (arr.length >= 1) {
            resourceType = arr[0];
        }
        if (arr.length >= 2) {
            resourceName = arr[1];
        }
        if (arr.length >= 3) {
            try {
                aclCode = Integer.valueOf(arr[2]);
            } catch (Exception e) {
                operationName = arr[2];
                Operation operation = this.operationService.getOperationByComponentAndOperationName(resourceType, resourceName, operationName);
                aclCode = isNull(operation) ? 0 : 1 << operation.getAclPos();
                System.out.println();
                System.out.println("aclCode: " + aclCode);
                System.out.println();
            }
        }
        return new AclPermission(resourceType, resourceName, aclCode);
    }
}
