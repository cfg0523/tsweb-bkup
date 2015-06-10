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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class RoleDaoTest {

    @Resource
    private RoleDao roleDao;

    private Role role;
    
    @Before
    public void init() {
        this.role = new Role("superuser", "superuser").setId("R0");
        this.roleDao.addEntity(this.role);
    }
    
    @After
    public void clear() {
        this.roleDao.deleteEntity(this.role);
    }
    
    @Test
    public void testUpdateEntity() {
        Role tmp = this.role.clone().setId(null).setDesc("superuserdesc");
        this.roleDao.updateEntity(tmp);
        tmp = this.roleDao.getEntity(tmp);
        
        Assert.assertEquals(this.role.getId(), tmp.getId());
        Assert.assertEquals(this.role.getName(), tmp.getName());
        Assert.assertEquals("superuserdesc", tmp.getDesc());
    }
    
}
