package com.techsen.tsweb.core.mapper;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.core.util.Log4jUtil;

/**
 * 公共的BaseMapper抽象类
 */
public abstract class BaseMapper<T extends BaseEntity<T>> implements Dao<T> {
    private Logger logger = Log4jUtil.getLogger(this);
    
    protected SqlSessionTemplate defaultSqlSessionTemplate;

    public abstract void setDefaultSqlSessionTemplate(
            SqlSessionTemplate defaultSqlSessionTemplate);

    private String getStatement(String statementId) {
        String statement = this.getClass().getName() + "." + statementId;
        logger.info(statement);
        return statement;
    }

    /**
     * 新增一个Entity对象
     */
    @Override
    public void addEntity(T t) {
        this.defaultSqlSessionTemplate.insert(getStatement("addEntity"), t);
    }

    /**
     * 根据Entity的id属性删除一个实体
     */
    @Override
    public void deleteEntity(T t) {
        this.defaultSqlSessionTemplate.delete(getStatement("deleteEntity"), t);
    }

    /**
     * 根据Entity的id属性更新一个实体
     */
    @Override
    public void updateEntity(T t) {
        this.defaultSqlSessionTemplate.update(getStatement("updateEntity"), t);
    }

    /**
     * 根据id查找一个实体
     */
    @Override
    public T getEntity(String id) {
        return this.defaultSqlSessionTemplate.selectOne(getStatement("getEntity"), id);
    }

}
