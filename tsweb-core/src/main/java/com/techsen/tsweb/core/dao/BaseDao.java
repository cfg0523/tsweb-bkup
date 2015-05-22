package com.techsen.tsweb.core.dao;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.core.util.Log4jUtil;

/**
 * 公共的BaseDao接口
 */
public abstract class BaseDao<T extends BaseEntity<T>> implements Dao<T> {
    private Logger logger = Log4jUtil.getLogger(this);
    
    protected SqlSessionTemplate defaultSqlSessionTemplate;

    public abstract void setDefaultSqlSessionTemplate(
            SqlSessionTemplate defaultSqlSessionTemplate);

    private String getStatement(String statementId) {
        String statement = this.getClass().getName() + "." + statementId;
        logger.info(statement);
        return statement;
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
