package com.techsen.tsweb.sys.mapper;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.techsen.tsweb.core.mapper.BaseMapper;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.domain.User;

@Repository
public class UserMapper extends BaseMapper<User> implements UserDao {

    @Override
    @Resource(name = "localSqlSessionTemplate")
    public void setDefaultSqlSessionTemplate(
            SqlSessionTemplate defaultSqlSessionTemplate) {
        this.defaultSqlSessionTemplate = defaultSqlSessionTemplate;
    }

}
