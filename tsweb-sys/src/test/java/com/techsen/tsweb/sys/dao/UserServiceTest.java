package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class UserServiceTest {

    @Resource
    private UserService userService;
    
    private User user;
    
    @Before
    public void init() {
        this.user = new User("testUser", "testPwd").setId("testUser");
        this.userService.addEntity(this.user);
    }

    @Test
    public void testAddEntity() {
        this.user.setPassword("password");
        this.userService.updateEntity(this.user);
    }
    
}
