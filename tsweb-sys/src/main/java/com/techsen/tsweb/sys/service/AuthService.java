package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.domain.User;

public interface AuthService {
    
    /**
     * 根据用户id或username获取Auths
     */
    public List<Auth> getAuthsByUser(User user);
}
