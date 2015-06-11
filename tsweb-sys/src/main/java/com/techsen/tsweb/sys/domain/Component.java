package com.techsen.tsweb.sys.domain;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 组件资源类<br/>
 * 通常是系统中的Controller资源和Service
 */
public class Component extends BaseEntity<Component> {

    private static final long serialVersionUID = -1236091399373795740L;

    private String name;
    private String type;
    private String desc;
    private String javaClass;

    /**
     * 该组件所拥有的操作集合
     */
    private List<Operation> operations;

    public Component() {
    }

    public Component(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Component(String name, String type, String desc) {
        this(name, type);
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public Component setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Component setType(String type) {
        this.type = type;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Component setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getJavaClass() {
        return javaClass;
    }

    public Component setJavaClass(String javaClass) {
        this.javaClass = javaClass;
        return this;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

}
