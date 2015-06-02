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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class RoleDaoTest {
    @Resource
    private RoleDao roleDao;
    
    private Role role;
    
    @Before
    public void init() {
        this.role = new Role("admin");
        this.roleDao.addEntity(role);
    }
    
    @After
    public void clear() {
        this.roleDao.deleteEntity(this.role);
    }
    
    @Test
    public void testUpdateEntity() {
        Role tmp = this.role.clone();
        tmp.setRoleName("name-admin");
        tmp.setRemark("test by admin");
        this.roleDao.updateEntity(tmp);
        
        tmp = this.roleDao.getEntity(this.role.getId());
        Assert.assertEquals("name-admin", tmp.getRoleName());
        Assert.assertEquals("test by admin", tmp.getRemark());
    }
    
    @Test
    public void testGetRoleByName() {
        Role tmp = this.roleDao.getRoleByName("admin");
        Assert.assertEquals("admin", tmp.getRoleName());
    }
    
    @Test
    public void testGetRolesByUserId() {
        String userId = "U1";
        List<Role> roles = this.roleDao.getRolesByUserId(userId);
        System.out.println(roles);
    }
    
}
