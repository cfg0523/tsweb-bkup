package com.techsen.tsweb.sys.dao;

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
public class UserRoleDaoTest {
    
    @Resource
    private UserRoleDao userRoleDao;
    
    @Resource
    private UserDao userDao;
    
    @Resource
    private RoleDao roleDao;
    
    private UserRole userRole;
    private User user;
    private Role role;
    
    @Before
    public void init() {
        this.user = new User("admin", "admin").setId("U0");
        this.role = new Role("superuser", "superuser").setId("R0");
        this.userRole = new UserRole(user, role).setId("UR0");
        
        this.userDao.addEntity(this.user);
        this.roleDao.addEntity(this.role);
        this.userRoleDao.addEntity(this.userRole);
    }
    
    @After
    public void clear() {
        this.userRoleDao.deleteEntity(this.userRole);
        this.roleDao.deleteEntity(this.role);
        this.userDao.deleteEntity(this.user);
    }
    
    @Test
    public void testGetRolesByUser() {
        List<Role> roles = this.userRoleDao.getRolesByUser(this.user);

        Assert.assertNotNull(roles);
        Assert.assertEquals(1, roles.size());
        Assert.assertEquals(this.role.getId(), roles.get(0).getId());
        Assert.assertEquals(this.role.getName(), roles.get(0).getName());
        Assert.assertEquals(this.role.getDesc(), roles.get(0).getDesc());
    }
    
    @Test
    public void testDeleteRolesByUser() {
        List<Role> roles = this.userRoleDao.getRolesByUser(this.user);
        Assert.assertNotNull(roles);
        Assert.assertEquals(1, roles.size());
        
        this.userRoleDao.deleteRolesByUser(this.user);
        
        roles = this.userRoleDao.getRolesByUser(this.user);
        Assert.assertNotNull(roles);
        Assert.assertEquals(0, roles.size());
    }
    
    @Test
    public void testGetUsersByRole() {
        List<User> users = this.userRoleDao.getUsersByRole(this.role);
        
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
        Assert.assertEquals(this.user.getId(), users.get(0).getId());
        Assert.assertEquals(this.user.getUsername(), users.get(0).getUsername());
        Assert.assertEquals(this.user.getPassword(), users.get(0).getPassword());
    }
    
    @Test
    public void testDeleteUsersByRole() {
        List<User> users = this.userRoleDao.getUsersByRole(this.role);
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
        
        this.userRoleDao.deleteUsersByRole(this.role);
        
        users = this.userRoleDao.getUsersByRole(this.role);
        Assert.assertNotNull(users);
        Assert.assertEquals(0, users.size());
    }
    
}
