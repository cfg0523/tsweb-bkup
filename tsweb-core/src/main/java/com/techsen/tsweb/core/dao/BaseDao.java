package com.techsen.tsweb.core.dao;

import static com.techsen.tsweb.core.util.ObjectUtil.getGenericType;

import org.mybatis.spring.SqlSessionTemplate;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 公共的BaseDao接口
 */
@SuppressWarnings("unchecked")
public abstract class BaseDao<T extends BaseEntity<T>> implements Dao<T> {

    protected SqlSessionTemplate defaultSqlSessionTemplate;

    public abstract void setDefaultSqlSessionTemplate(
            SqlSessionTemplate defaultSqlSessionTemplate);

    private Class<T> clazz = (Class<T>) getGenericType(this);

    private String getStatement(String statementId) {
        return this.clazz.getName() + "." + statementId;
    }

    @Override
    public void addEntity(T t) {
        this.defaultSqlSessionTemplate.insert(getStatement("addEntity"), t);
    }

    @Override
    public void deleteEntity(T t) {
        this.defaultSqlSessionTemplate.delete(getStatement("deleteEntity"), t);
    }

    @Override
    public void updateEntity(T t) {
        this.defaultSqlSessionTemplate.update(getStatement("updateEntity"), t);
    }

    @Override
    public T getEntity(String id) {
        return this.defaultSqlSessionTemplate.selectOne("getEntity", id);
    }

}
