package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.AclPermission;

/**
 * 访问控制列表记录
 */
public class Acl extends BaseEntity<Acl> {

    private static final long serialVersionUID = -4382277645585649978L;

    private PrincipalType principalType;
    private String principalName;
    private ResourceType resourceType;
    private String resourceName;
    private int aclCode;

    public PrincipalType getPrincipalType() {
        return principalType;
    }

    public Acl setPrincipalType(PrincipalType principalType) {
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

    public ResourceType getResourceType() {
        return resourceType;
    }

    public Acl setResourceType(ResourceType resourceType) {
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
