package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class UserDaoTest {
    
    @Resource
    private UserDao userDao;
    
    private User user;
    
    @Before
    public void init() {
        this.user = new User("admin", "admin").setId("U0");
        this.userDao.addEntity(this.user);
    }
    
    @After
    public void clear() {
        this.userDao.deleteEntity(this.user);
    }
    
    @Test
    public void testGetById() {
        User tmp = this.userDao.getById(this.user.getId());
        System.out.println();
        System.out.println(tmp);
        System.out.println();
    }
    
    @Test
    public void testUpdateEntity() {
        User tmp = this.user.clone().setId(null).setPassword("password");
        this.userDao.updateEntity(tmp);
        tmp = this.userDao.getEntity(tmp);
        
        Assert.assertEquals(this.user.getId(), tmp.getId());
        Assert.assertEquals(this.user.getUsername(), tmp.getUsername());
        Assert.assertEquals("password", tmp.getPassword());
    }
    
}
