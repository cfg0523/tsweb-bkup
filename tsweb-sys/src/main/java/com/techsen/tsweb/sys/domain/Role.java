package com.techsen.tsweb.sys.domain;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 角色实体
 */
public class Role extends BaseEntity<Role> {
    private static final long serialVersionUID = -7838821087064025453L;

    private String roleName;
    
    /**
     * 角色所拥有的权限
     */
    private List<Auth> auths;

    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public List<Auth> getAuths() {
        return auths;
    }

    public Role setAuths(List<Auth> auths) {
        this.auths = auths;
        return this;
    }

}
