package com.techsen.tsweb.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class RoleServiceTest {

    @Resource
    private RoleService roleService;

    @Resource
    private UserService userService;

    @Resource
    private CacheManager cacheManager;

    @Test
    public void testGetRolesByUser() {
        List<Role> roles = this.roleService.getRolesByUser(new User("hayden"));
        System.out.println();
        for (Role role : roles) {
            System.out.println(role);
        }
        System.out.println();

        roles = this.roleService.getRolesByUser(new User("hayden"));
        System.out.println();
        for (Role role : roles) {
            System.out.println(role);
        }
        System.out.println();
    }

}
