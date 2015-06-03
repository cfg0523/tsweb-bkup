package com.techsen.tsweb.sys.service;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.util.SysConst;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class UserServiceTest {
    
    @Resource
    private UserService userService;
    
    @Resource
    private CacheManager cacheManager;
    
    @Test
    public void testGetUserByUser() {
        User user = this.userService.getUserByUser(new User("hayden"));
        System.out.println();
        System.out.println(user);
        System.out.println(user.getRoles());
        System.out.println(user.getAuths());
        System.out.println();
        
        user = this.userService.getUserByUser(new User("hayden"));
        System.out.println();
        System.out.println(user);
        System.out.println(user.getRoles());
        System.out.println(user.getAuths());
        System.out.println();
    }
    
    @Test
    public void testCache() {
        User user = this.userService.getUserByUser(new User("hayden"));
        System.out.println();
        System.out.println("user --> " + user);
        Cache cache = (Cache) cacheManager.getCache(SysConst.CACHE_USER).getNativeCache();
        for (Object key : cache.getKeys()) {
            System.out.println(key + " --> " + cache.get(key).getObjectValue());
        }
        System.out.println();
    }
}
