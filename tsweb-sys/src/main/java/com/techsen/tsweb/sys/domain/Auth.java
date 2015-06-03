package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 权限实体
 */
public class Auth extends BaseEntity<Auth> {
    private static final long serialVersionUID = 1651997840821737066L;

    private String authName;
    private String authDesc;

    public Auth() {
    }

    public Auth(String authName, String authDesc) {
        this.authName = authName;
        this.authDesc = authDesc;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthDesc() {
        return authDesc;
    }

    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc;
    }
    
}
