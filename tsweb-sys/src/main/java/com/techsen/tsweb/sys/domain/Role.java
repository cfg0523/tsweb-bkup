package com.techsen.tsweb.sys.domain;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.AuthPrincipal;

/**
 * 角色实体
 */
public class Role extends BaseEntity<Role> implements AuthPrincipal {
    private static final long serialVersionUID = -7838821087064025453L;

    private static final String PRINCIPAL_TYPE = "role";

    private String name;
    private String desc;
    
    /**
     * 角色所包含的用户集合
     */
    private List<User> users;
    
    public Role() {}

    public Role(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getPrincipalType() {
        return PRINCIPAL_TYPE;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Role setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public Role setUsers(List<User> users) {
        this.users = users;
        return this;
    }

}
