package com.techsen.tsweb.sys.domain;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.AuthResource;

/**
 * 组件资源类<br/>
 * 通常是系统中的Controller资源和Service
 */
public class Component extends BaseEntity<Component> implements AuthResource {

    private static final long serialVersionUID = -1236091399373795740L;

    private String name;
    private String desc;
    private String resourceType = "controller";
    private String javaType;

    /**
     * 该组件所拥有的操作集合
     */
    private List<Operation> operations;

    public Component() {
    }

    public Component(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public Component setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Component setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getResourceType() {
        return resourceType;
    }

    public Component setResourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    public String getJavaType() {
        return javaType;
    }

    public Component setJavaType(String javaType) {
        this.javaType = javaType;
        return this;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

}
