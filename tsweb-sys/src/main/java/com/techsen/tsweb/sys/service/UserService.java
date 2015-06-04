package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.sys.domain.User;

public interface UserService {
    
    /**
     * 根据用户Id或username获取User
     */
    public User getUser(User user);
    
    /**
     * 新增用户
     */
    public void addUser(User user);
    
    /**
     * 修改用户
     */
    public void updateUser(User user);
    
    /**
     * 删除用户
     */
    public void deleteUser(User user);
}
