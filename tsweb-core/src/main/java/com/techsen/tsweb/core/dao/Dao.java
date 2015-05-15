package com.techsen.tsweb.core.dao;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 公共的BaseDao接口
 */
public interface Dao<T extends BaseEntity<T>> {
    void addEntity(T t);
    void deleteEntity(T t);
    void updateEntity(T t);
    T getEntity(String id);
}
