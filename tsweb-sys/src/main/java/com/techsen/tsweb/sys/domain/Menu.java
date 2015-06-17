package com.techsen.tsweb.sys.domain;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.AuthResource;
import com.techsen.tsweb.sys.auth.AuthResourceType;

/**
 * 菜单对象
 */
public class Menu extends BaseEntity<Menu> implements AuthResource {

    private static final long serialVersionUID = -7771118378089691104L;

    private String name; // 菜单资源名
    private String desc; // 菜单描述
    private String path; // 菜单路径
    private AuthResourceType resourceType = AuthResourceType.Menu; // 菜单类别
    private int aclPos = 1; // 菜单访问控制位

    /**
     * 父级菜单
     */
    private Menu parent;
    
    /**
     * 所有直接子菜单集合
     */
    private List<Menu> subMenus;

    public Menu() {
    }

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Menu setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Menu setPath(String path) {
        this.path = path;
        return this;
    }

    public int getAclPos() {
        return aclPos;
    }

    public Menu setAclPos(int aclPos) {
        this.aclPos = aclPos;
        return this;
    }

    public Menu setResourceType(AuthResourceType resourceType) {
        this.resourceType = resourceType;
        return this;
    }
    
    public AuthResourceType getResourceType() {
        return resourceType;
    }

    public Menu getParent() {
        return parent;
    }

    public Menu setParent(Menu parent) {
        this.parent = parent;
        return this;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public Menu setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
        return this;
    }

}
