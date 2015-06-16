package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 访问控制列表记录
 */
public class Acl extends BaseEntity<Acl> {

    private static final long serialVersionUID = -4382277645585649978L;

    private String principalId;
    private PrincipalType principalType;
    private String resourceId;
    private ResourceType resourceType;
    private int aclCode;

    public String getPrincipalId() {
        return principalId;
    }

    public Acl setPrincipalId(String principalId) {
        this.principalId = principalId;
        return this;
    }

    public PrincipalType getPrincipalType() {
        return principalType;
    }

    public Acl setPrincipalType(PrincipalType principalType) {
        this.principalType = principalType;
        return this;
    }

    public String getResourceId() {
        return resourceId;
    }

    public Acl setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public Acl setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
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
