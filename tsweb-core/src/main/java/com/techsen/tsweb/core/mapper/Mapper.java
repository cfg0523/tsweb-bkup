package com.techsen.tsweb.core.mapper;

import java.io.Serializable;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 公共DAO接口
 */
public interface Mapper<T extends BaseEntity<T>> {
    void addEntity(T t);
    void deleteEntity(T t);
    void updateEntity(T t);
    T getEntity(Serializable id);
}
