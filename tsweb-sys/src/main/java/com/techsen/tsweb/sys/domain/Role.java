package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 角色实体
 */
public class Role extends BaseEntity<Role> {
    private static final long serialVersionUID = -7838821087064025453L;

    private String name;
    private String desc;
    
    public Role() {}

    public Role(String name, String desc) {
        this.name = name;
        this.desc = desc;
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

}
