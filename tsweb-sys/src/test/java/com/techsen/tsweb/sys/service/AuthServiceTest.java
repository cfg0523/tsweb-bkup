package com.techsen.tsweb.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class AuthServiceTest {

    @Resource
    private AuthService authService;

    @Resource
    private CacheManager cacheManager;
    
    @Test
    public void testGetAuthsByUser() {
        List<Auth> auths = this.authService.getAuthsByUser(new User("hayden"));
        System.out.println();
        for (Auth auth : auths) {
            System.out.println(auth);
        }
        System.out.println();
        
        auths = this.authService.getAuthsByUser(new User("hayden"));
        System.out.println();
        for (Auth auth : auths) {
            System.out.println(auth);
        }
        System.out.println();
    }

}
