package com.techsen.tsweb.core.dao;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 公共的BaseDao接口
 */
public interface Dao<T extends BaseEntity<T>> {
    
    /**
     * 新增一个Entity对象
     */
    void addEntity(T t);

    /**
     * 根据Entity的id属性删除一个实体
     */
    void deleteEntity(T t);
    
    /**
     * 根据Entity的id属性更新一个实体
     */
    void updateEntity(T t);
    
    /**
     * 根据id查找一个实体
     */
    T getEntity(String id);
}
