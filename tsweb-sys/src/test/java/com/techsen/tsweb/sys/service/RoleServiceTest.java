package com.techsen.tsweb.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.core.util.ValidUtil;
import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class RoleServiceTest {

    @Resource
    private RoleService roleService;

    @Test
    public void testGetRolesByUser() {
        List<Role> roles = this.roleService.getRolesByUser(new User("hayden"));
        System.out.println();
        for (Role role : roles) {
            System.out.println(role);
            if (ValidUtil.isValid(role.getAuths())) {
                for (Auth auth : role.getAuths()) {
                    System.out.println(auth);
                }
            }
        }
        System.out.println();
        
        roles = this.roleService.getRolesByUser(new User("hayden"));
        System.out.println();
        for (Role role : roles) {
            System.out.println(role);
            if (ValidUtil.isValid(role.getAuths())) {
                for (Auth auth : role.getAuths()) {
                    System.out.println(auth);
                }
            }
        }
        System.out.println();
    }

}
