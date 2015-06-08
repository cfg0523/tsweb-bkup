package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 菜单
 */
public class Menu extends BaseEntity<Menu> {

    private static final long serialVersionUID = -7771118378089691104L;

    private String path; // 菜单路径
    private String name; // 菜单名
    private String auth; // 需要的权限
    private String parent; // 父级菜单

    public Menu() {
    }

    public Menu(String path, String name) {
        this.path = path;
        this.name = name;
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

}
