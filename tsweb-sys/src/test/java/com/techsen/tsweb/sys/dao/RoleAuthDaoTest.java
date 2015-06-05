package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.RoleAuth;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class RoleAuthDaoTest {
    
    @Resource
    private RoleDao roleDao;
    
    @Resource
    private AuthDao authDao;
    
    @Resource
    private RoleAuthDao roleAuthDao;
    
    private RoleAuth roleAuth;
    private Role role;
    private Auth auth;
    
    @Before
    public void init() {
        this.role = new Role("tmpRole", "tmpDesc").setId("tmprole");
        this.auth = new Auth("tmpAuth", "tmpDesc").setId("tmpauth");
        this.roleAuth = new RoleAuth(role, auth).setId("tmproleauth");
        
        this.roleDao.addEntity(this.role);
        this.authDao.addEntity(this.auth);
        this.roleAuthDao.addEntity(this.roleAuth);
    }
    
    @After
    public void clear() {
        this.roleAuthDao.deleteEntity(this.roleAuth);
        this.authDao.deleteEntity(this.auth);
        this.roleDao.deleteEntity(this.role);
    }
    
    @Test
    public void testGetEntity() {
        RoleAuth roleAuth = this.roleAuthDao.getEntity(this.roleAuth);

        Assert.assertEquals(this.roleAuth, roleAuth);
        Assert.assertEquals(this.role, roleAuth.getRole());
        Assert.assertEquals(this.auth, roleAuth.getAuth());
        
        System.out.println();
        System.out.println(roleAuth);
        System.out.println(roleAuth.getRole());
        System.out.println(roleAuth.getAuth());
        System.out.println();
    }
    
    @Test
    public void testUpdateEntity() {
        RoleAuth tmpRoleAuth = this.roleAuth.clone();
        Role tmpRole = tmpRoleAuth.getRole().setId("R2");
        Auth tmpAuth = tmpRoleAuth.getAuth().setId("A1");
        
        this.roleAuthDao.updateEntity(tmpRoleAuth);
        tmpRoleAuth = this.roleAuthDao.getEntity(tmpRoleAuth);
        Role expectRole = this.roleDao.getEntity(tmpRole);
        Auth expectAuth = this.authDao.getEntity(tmpAuth);
        
        Assert.assertEquals(this.roleAuth, tmpRoleAuth);
        Assert.assertEquals(expectRole, tmpRoleAuth.getRole());
        Assert.assertEquals(expectAuth, tmpRoleAuth.getAuth());
        
        System.out.println();
        System.out.println(tmpRoleAuth);
        System.out.println(tmpRoleAuth.getRole());
        System.out.println(tmpRoleAuth.getAuth());
        System.out.println();
    }
}
