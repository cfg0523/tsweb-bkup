package com.techsen.tsweb.sys.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private CacheManager cacheManager;

    @Test
    public void testGetUserByUser() {
        User user = this.userService.getUser(new User("hayden"));
        System.out.println();
        System.out.println(user);
        System.out.println();
    }

    @Test
    public void testAddUser() {
        User user = new User("testUser", "testUser");
        System.out.println();
        System.out.println(user);
        this.userService.addUser(user);
        System.out.println(this.userService.getUser(user));
        System.out.println();
        this.userService.deleteUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User("testUser", "testUser");
        this.userService.addUser(user);
        System.out.println();
        System.out.println(user);
        user.setPassword("testUser-pwd");
        this.userService.updateUser(user);
        System.out.println(this.userService.getUser(user));
        System.out.println();
        this.userService.deleteUser(user);
    }

    @Test
    public void testGetUser() {
        User user = this.userService.getUser(new User().setUsername("hayden"));
        user.setPassword("hayden-pwd");
        System.out.println();
        this.userService.getUser(user.setId(null));
        System.out.println();
    }
}
