package com.techsen.tsweb.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    private User user;
    private Role role;
    private UserRole userRole;

    @Before
    public void init() {
        this.user = new User("admin", "admin");
        this.userService.addUser(this.user);
        User tmpUser = this.userService.getUser(this.user);

        Assert.assertNotNull(tmpUser);
        Assert.assertNotNull(tmpUser.getId());

        this.role = new Role("superuser", "superuser");
        this.roleService.addRole(this.role);
        Role tmpRole = this.roleService.getRole(this.role);

        Assert.assertNotNull(tmpRole);
        Assert.assertNotNull(tmpRole.getId());

        this.userRole = new UserRole(tmpUser, tmpRole);
        UserRole tmpUserRole = this.userService.addRole(this.userRole);

        Assert.assertNotNull(tmpUserRole);
        Assert.assertNotNull(tmpUserRole.getId());
    }

    @After
    public void clear() {
        this.userService.deleteRole(this.userRole);
        this.roleService.deleteRole(this.role);
        this.userService.deleteUser(this.user);
    }

    @Test
    public void testUpdateUser() {
        User tmp = this.user.clone();
        this.userService.updateUser(tmp);
        tmp = this.userService.getUser(tmp);

        System.out.println();
        System.out.println("tmp: " + tmp);
        System.out.println();
        
        Assert.assertNotNull(tmp);
        Assert.assertNotNull(tmp.getUpdateDate());
    }

    @Test
    public void testDeleteUser() {
        List<Role> roles = this.userService.getRolesByUser(this.user);
        Assert.assertNotNull(roles);
        Assert.assertEquals(1, roles.size());

        this.userService.deleteUser(this.user);
        
        roles = this.userService.getRolesByUser(this.user);
        Assert.assertNotNull(roles);
        Assert.assertEquals(0, roles.size());
    }

    @Test
    public void testAddRoleAndDeleteRole() {
        Role tmpRole = new Role("tmpRole", "tmpRole");
        this.roleService.addRole(tmpRole);
        tmpRole = this.roleService.getRole(tmpRole);
        Assert.assertNotNull(tmpRole);
        Assert.assertNotNull(tmpRole.getId());
        
        UserRole tmpUserRole = new UserRole(this.user, tmpRole);
        this.userService.addRole(tmpUserRole);
        
        List<Role> roles = this.userService.getRolesByUser(this.user);
        Assert.assertNotNull(roles);
        Assert.assertEquals(2, roles.size());
        
        this.roleService.deleteRole(tmpRole);
        
        roles = this.userService.getRolesByUser(this.user);
        Assert.assertNotNull(roles);
        Assert.assertEquals(1, roles.size());
    }
}
