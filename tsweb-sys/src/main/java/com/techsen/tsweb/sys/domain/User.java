package com.techsen.tsweb.sys.domain;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.AuthPrincipal;

/**
 * 用户实体
 */
public class User extends BaseEntity<User> implements AuthPrincipal {
    private static final long serialVersionUID = -6378136187265089253L;
    
    private static final String PRINCIPAL_TYPE = "user";
    
    private String username;
    private String password;
    
    /**
     * 用户所拥有的角色集合
     */
    private List<Role> roles;
    
    public User() {}
    
    public User(String username) {
        this.username = username;
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPrincipalType() {
        return PRINCIPAL_TYPE;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

}
