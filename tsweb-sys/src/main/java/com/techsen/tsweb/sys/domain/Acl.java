package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.AclPermission;
import com.techsen.tsweb.sys.auth.AuthPrincipalType;
import com.techsen.tsweb.sys.auth.AuthResourceType;

/**
 * 访问控制列表记录
 */
public class Acl extends BaseEntity<Acl> {

    private static final long serialVersionUID = -4382277645585649978L;

    private AuthPrincipalType principalType;
    private String principalName;
    private AuthResourceType resourceType;
    private String resourceName;
    private int aclCode;

    public AuthPrincipalType getPrincipalType() {
        return principalType;
    }

    public Acl setPrincipalType(AuthPrincipalType principalType) {
        this.principalType = principalType;
        return this;
    }
    
    public AclPermission toAclPermission() {
        return new AclPermission(this.resourceType.toString(), this.resourceName, this.aclCode);
    }
    
    public String toAclPermissionString() {
        return this.resourceType + ":" + this.resourceName + ":" + this.aclCode;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public Acl setPrincipalName(String principalName) {
        this.principalName = principalName;
        return this;
    }

    public AuthResourceType getResourceType() {
        return resourceType;
    }

    public Acl setResourceType(AuthResourceType resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Acl setResourceName(String resourceName) {
        this.resourceName = resourceName;
        return this;
    }

    public int getAclCode() {
        return aclCode;
    }

    public Acl setAclCode(int aclCode) {
        this.aclCode = aclCode;
        return this;
    }

}
