package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 权限实体
 */
public class Auth extends BaseEntity<Auth> {
    private static final long serialVersionUID = 1651997840821737066L;

    private String name;
    private String desc;

    public Auth() {
    }

    public Auth(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
