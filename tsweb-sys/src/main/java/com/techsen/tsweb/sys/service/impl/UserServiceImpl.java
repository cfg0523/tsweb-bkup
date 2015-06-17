package com.techsen.tsweb.sys.service.impl;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseService<User, UserDao> implements UserService {
    
}
