package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.sys.domain.User;

public interface UserService {
    
    /**
     * 根据用户Id或username获取User
     */
    public User getUserByUser(User user);
}
