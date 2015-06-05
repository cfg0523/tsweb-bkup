package com.techsen.tsweb.sys.dao;

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
    private UserDao userDao;
    
    @Resource
    private RoleDao roleDao;
    
    @Resource
    private UserRoleDao userRoleDao;
    
    private UserRole userRole;
    private User user;
    private Role role;
    
    @Before
    public void init() {
        this.user = new User("tmpUser", "tmpPwd").setId("tmpuser");
        this.role = new Role("tmpRole", "tmpDesc").setId("tmprole");
        this.userRole = new UserRole(user, role).setId("tmpuserrole");
        
        this.userDao.addEntity(this.user);
        this.roleDao.addEntity(this.role);
        this.userRoleDao.addEntity(this.userRole);
    }
    
    @After
    public void clear() {
        this.userRoleDao.deleteEntity(this.userRole);
        this.userDao.deleteEntity(this.user);
        this.roleDao.deleteEntity(this.role);
    }
    
    @Test
    public void testGetEntity() {
        UserRole userRole = this.userRoleDao.getEntity(this.userRole);

        Assert.assertEquals(this.userRole, userRole);
        Assert.assertEquals(this.user, userRole.getUser());
        Assert.assertEquals(this.role, userRole.getRole());
        
        System.out.println();
        System.out.println(userRole);
        System.out.println(userRole.getUser());
        System.out.println(userRole.getRole());
        System.out.println();
    }
    
    @Test
    public void testUpdateEntity() {
        UserRole tmpUserRole = this.userRole.clone();
        User tmpUser = tmpUserRole.getUser().setId("U1");
        Role tmpRole = tmpUserRole.getRole().setId("R2");
        
        this.userRoleDao.updateEntity(tmpUserRole);
        tmpUserRole = this.userRoleDao.getEntity(tmpUserRole);
        User expectUser = this.userDao.getEntity(tmpUser);
        Role expectRole = this.roleDao.getEntity(tmpRole);
        
        Assert.assertEquals(this.userRole, tmpUserRole);
        Assert.assertEquals(expectUser, tmpUserRole.getUser());
        Assert.assertEquals(expectRole, tmpUserRole.getRole());
        
        System.out.println();
        System.out.println(tmpUserRole);
        System.out.println(tmpUserRole.getUser());
        System.out.println(tmpUserRole.getRole());
        System.out.println();
    }
}
