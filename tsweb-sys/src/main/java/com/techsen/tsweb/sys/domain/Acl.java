package com.techsen.tsweb.sys.domain;

import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.AclPermission;

/**
 * 访问控制列表记录
 */
public class Acl extends BaseEntity<Acl> {

    private static final long serialVersionUID = -4382277645585649978L;

    private String principalType;
    private String principalName;
    private String resourceType;
    private String resourceName;
    private int aclCode;

    public Acl setPermission(int aclPos, boolean permission) {
        if (aclPos > 31 || aclPos < 0) {
            throwRuntimeException("aclPos取值只能在0到31之间");
        }
        int val = 1 << aclPos;
        this.aclCode = permission ? this.aclCode | val : this.aclCode & ~val;
        return this;
    }
    
    public boolean checkPermission(int aclPos) {
        if (aclPos > 31 || aclPos < 0) {
            throwRuntimeException("aclPos取值只能在0到31之间");
        }
        int val = 1 << aclPos;
        return (this.aclCode & val) > 0;
    }

    public String getPrincipalType() {
        return principalType;
    }

    public Acl setPrincipalType(String principalType) {
        this.principalType = principalType;
        return this;
    }

    public AclPermission toAclPermission() {
        return new AclPermission(this.resourceType.toString(),
                this.resourceName, this.aclCode);
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

    public String getResourceType() {
        return resourceType;
    }

    public Acl setResourceType(String resourceType) {
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
