package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 用户角色
 */
public class UserRole extends BaseEntity<UserRole> {

    private static final long serialVersionUID = 5054914837898444376L;

    private User user;
    private Role role;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public UserRole setUser(User user) {
        this.user = user;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserRole setRole(Role role) {
        this.role = role;
        return this;
    }

}
