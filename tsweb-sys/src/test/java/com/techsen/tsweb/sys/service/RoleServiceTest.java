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
public class RoleServiceTest {

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
    public void testUpdateRole() {
        Role tmp = this.role.clone();
        this.roleService.updateRole(tmp);
        tmp = this.roleService.getRole(tmp);

        System.out.println();
        System.out.println("tmp: " + tmp);
        System.out.println();
        
        Assert.assertNotNull(tmp);
        Assert.assertNotNull(tmp.getUpdateDate());
    }
    
    @Test
    public void testDeleteRole() {
        List<User> users = this.roleService.getUsersByRole(this.role);
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());

        this.roleService.deleteRole(this.role);
        
        users = this.roleService.getUsersByRole(this.role);
        Assert.assertNotNull(users);
        Assert.assertEquals(0, users.size());
    }

    @Test
    public void testAddUserAndDeleteUser() {
        User tmpUser = new User("tmpUser", "tmpUser");
        this.userService.addUser(tmpUser);
        tmpUser = this.userService.getUser(tmpUser);
        Assert.assertNotNull(tmpUser);
        Assert.assertNotNull(tmpUser.getId());
        
        UserRole tmpUserRole = new UserRole(tmpUser, this.role);
        this.roleService.addUser(tmpUserRole);
        
        List<User> users = this.roleService.getUsersByRole(this.role);
        Assert.assertNotNull(users);
        Assert.assertEquals(2, users.size());
        
        this.userService.deleteUser(tmpUser);
        
        users = this.roleService.getUsersByRole(this.role);
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
    }
}
