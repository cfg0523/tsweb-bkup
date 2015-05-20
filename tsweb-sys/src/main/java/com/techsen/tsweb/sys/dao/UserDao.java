package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.techsen.tsweb.core.dao.BaseDao;
import com.techsen.tsweb.sys.domain.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> {

    @Override
    @Resource(name = "localSqlSessionTemplate")
    public void setDefaultSqlSessionTemplate(
            SqlSessionTemplate defaultSqlSessionTemplate) {
        this.defaultSqlSessionTemplate = defaultSqlSessionTemplate;
    }

}
