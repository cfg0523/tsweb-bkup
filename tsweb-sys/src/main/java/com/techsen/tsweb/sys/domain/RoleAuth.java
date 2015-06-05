package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 角色权限
 */
public class RoleAuth extends BaseEntity<RoleAuth> {

    private static final long serialVersionUID = 3861064547106469905L;

    private Role role;
    private Auth auth;

    public RoleAuth() {
    }

    public RoleAuth(Role role, Auth auth) {
        this.role = role;
        this.auth = auth;
    }

    public Role getRole() {
        return role;
    }

    public RoleAuth setRole(Role role) {
        this.role = role;
        return this;
    }

    public Auth getAuth() {
        return auth;
    }

    public RoleAuth setAuth(Auth auth) {
        this.auth = auth;
        return this;
    }

}
