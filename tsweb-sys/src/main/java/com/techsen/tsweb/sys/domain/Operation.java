package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 系统中的组件操作资源<br/>
 * 一般是Controller和Service中的方法
 */
public class Operation extends BaseEntity<Operation> {

    private static final long serialVersionUID = -6509084412073662735L;

    private String name;
    private String diff;
    private String desc;
    private int aclBit;
    
    /**
     * 该操作所属的组件
     */
    private Component component;
    
    public Operation() {
    }
    
    public Operation(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public Operation setName(String name) {
        this.name = name;
        return this;
    }

    public String getDiff() {
        return diff;
    }

    public Operation setDiff(String diff) {
        this.diff = diff;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Operation setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public int getAclBit() {
        return aclBit;
    }

    public Operation setAclBit(int aclBit) {
        this.aclBit = aclBit;
        return this;
    }

    public Component getComponent() {
        return component;
    }

    public Operation setComponent(Component component) {
        this.component = component;
        return this;
    }

}
