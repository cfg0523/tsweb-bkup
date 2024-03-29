package com.techsen.tsweb.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseService<User, UserDao> implements UserService {

    @Override
    @Resource
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getAllUsers() {
        return this.dao.getAllUsers();
    }
    
}
