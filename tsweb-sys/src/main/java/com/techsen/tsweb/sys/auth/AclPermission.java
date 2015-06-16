package com.techsen.tsweb.sys.auth;

import org.apache.shiro.authz.Permission;

import com.techsen.tsweb.core.domain.BaseObject;

public class AclPermission extends BaseObject<AclPermission> implements Permission {
    
    private static final long serialVersionUID = -3937296852119792240L;
    
    private String resourceType = "*";
    private String resourceName = "*";
    private int aclCode = 0xFFFFFFFF;

    public AclPermission() {
    }

    public AclPermission(String permissionString) {
        String[] arr = permissionString.split(":");
        if (arr.length >= 1) {
            this.resourceType = arr[0];
        }
        if (arr.length >= 2) {
            this.resourceName = arr[1];
        }
        if (arr.length >= 3) {
            this.aclCode = Integer.valueOf(arr[2]);
        }
    }
    
    public AclPermission(String resourceType, String resourceName, int aclCode) {
        this.resourceType = resourceType;
        this.resourceName = resourceName;
        this.aclCode = aclCode;
    }

    @Override
    public boolean implies(Permission permission) {
        if (!(permission instanceof AclPermission)) {
            return false;
        }
        AclPermission other = (AclPermission) permission;
        if (!"*".equals(this.resourceType)
                && !this.resourceType.equals(other.getResourceType())) {
            return false;
        }
        if (!"*".equals(this.resourceName)
                && !this.resourceName.equals(other.getResourceName())) {
            return false;
        }
        return (this.aclCode & other.getAclCode()) > 0;
    }

    public String getResourceType() {
        return resourceType;
    }

    public AclPermission setResourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    public String getResourceName() {
        return resourceName;
    }

    public AclPermission setResourceName(String resourceName) {
        this.resourceName = resourceName;
        return this;
    }

    public int getAclCode() {
        return aclCode;
    }

    public AclPermission setAclCode(int aclCode) {
        this.aclCode = aclCode;
        return this;
    }

}
