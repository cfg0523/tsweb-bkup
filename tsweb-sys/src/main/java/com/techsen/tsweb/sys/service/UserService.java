package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.domain.User;

public interface UserService extends Service<User> {

    public List<User> getAllUsers();
    
}
