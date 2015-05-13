package com.techsen.tsweb.core.dao;

import java.io.Serializable;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 抽象BaseDao类，实现公共Dao定义的公共方法
 */
public abstract class BaseDao<T extends BaseEntity<T>> implements Dao<T>{

    @Override
    public void addEntity(T t) {
        
    }

    @Override
    public void deleteEntity(T t) {
        
    }

    @Override
    public void updateEntity(T t) {
        
    }

    @Override
    public T getEntity(Serializable id) {
        return null;
    }

}
