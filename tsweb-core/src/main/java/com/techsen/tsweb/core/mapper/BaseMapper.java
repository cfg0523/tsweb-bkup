package com.techsen.tsweb.core.mapper;

import java.io.Serializable;

import org.mybatis.spring.SqlSessionTemplate;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 抽象BaseDao类，实现公共Dao定义的公共方法
 */
public abstract class BaseMapper<T extends BaseEntity<T>> implements Mapper<T> {

    protected SqlSessionTemplate defaultSqlSessionTemplate;

    public abstract void setDefaultSqlSessionTemplate(
            SqlSessionTemplate defaultSqlSessionTemplate);

    @Override
    @SuppressWarnings("unchecked")
    public void addEntity(T t) {
        this.defaultSqlSessionTemplate.getMapper(this.getClass()).addEntity(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deleteEntity(T t) {
        this.defaultSqlSessionTemplate.getMapper(this.getClass()).deleteEntity(
                t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void updateEntity(T t) {
        this.defaultSqlSessionTemplate.getMapper(this.getClass()).updateEntity(
                t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getEntity(Serializable id) {
        return (T) this.defaultSqlSessionTemplate.getMapper(this.getClass())
                .getEntity(id);
    }

}
