package com.techsen.tsweb.sys.domain;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 用户实体
 */
public class User extends BaseEntity<User> {
    private static final long serialVersionUID = -6378136187265089253L;
    
    private String username;
    private String password;
    
    /**
     * 用户的角色
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

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
