package com.techsen.tsweb.core.domain;

import java.io.Serializable;

import com.techsen.tsweb.core.util.ObjectUtil;

/**
 * 一个对象基类，提供公共的
 */
@SuppressWarnings("serial")
public abstract class BaseObject<T> implements Serializable {

    /**
     * 公共的toString()方法，供子类继承
     */
    @Override
    public String toString() {
        return ObjectUtil.toString(this);
    }

    /**
     * 公共的clone方法，供子类继承
     */
    @Override
    public T clone() {
        return ObjectUtil.clone(this);
    }

}
