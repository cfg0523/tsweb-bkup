package com.techsen.tsweb.sys.mapper;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.techsen.tsweb.core.mapper.BaseMapper;
import com.techsen.tsweb.sys.domain.User;

@Component
public class UserMapper extends BaseMapper<User> {

    @Override
    @Resource(name = "localSqlSessionTemplate")
    public void setDefaultSqlSessionTemplate(
            SqlSessionTemplate defaultSqlSessionTemplate) {
        this.defaultSqlSessionTemplate = defaultSqlSessionTemplate;
    }
    
}
