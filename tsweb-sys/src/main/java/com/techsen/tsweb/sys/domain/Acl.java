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

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public PrincipalType getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(PrincipalType principalType) {
        this.principalType = principalType;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public int getAclCode() {
        return aclCode;
    }

    public void setAclCode(int aclCode) {
        this.aclCode = aclCode;
    }

}
