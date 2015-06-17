package com.techsen.tsweb.core.dao;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 公共的Dao接口
 */
public interface Dao<T extends BaseEntity<T>> {

    /**
     * 根据id查找一个实体
     */
    T getById(String entityId);
    
    /**
     * 根据id或实体对象的唯一键查找一个实体
     */
    T getEntity(T entity);

    /**
     * 新增一个Entity对象
     */
    void addEntity(T entity);

    /**
     * 根据Entity的id属性删除一个实体
     */
    void deleteEntity(T entity);

    /**
     * 根据Entity的id属性更新一个实体
     */
    void updateEntity(T entity);
}
