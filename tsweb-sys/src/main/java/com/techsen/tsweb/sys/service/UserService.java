package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.sys.domain.User;

public interface UserService {

    /**
     * 根据userId获取User
     */
    User getUser(String userId);

    /**
     * 根据username获取User
     */
    User getUserByUsername(String username);

    /**
     * 添加User
     */
    void addUser(User user);

    /**
     * 根据userId删除User
     */
    void deleteUser(User user);

    /**
     * 根据userId修改User
     */
    void updateUser(User user);
    
}
