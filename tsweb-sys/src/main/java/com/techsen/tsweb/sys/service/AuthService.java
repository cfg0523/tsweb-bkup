package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.sys.domain.Auth;

public interface AuthService {
    
    /**
     * 根据authId获取Auth
     */
    Auth getAuth(String authId);

    /**
     * 根据authName获取Auth
     */
    Auth getAuthByAuthName(String authName);

    /**
     * 添加Auth
     */
    void addAuth(Auth auth);

    /**
     * 根据authId删除Auth
     */
    void deleteAuth(Auth auth);

    /**
     * 根据authId修改Auth
     */
    void updateAuth(Auth auth);

    /**
     * 根据userId获取用户的所有Auth
     */
    List<Auth> getAuthsByUserId(String userId);
    
}
