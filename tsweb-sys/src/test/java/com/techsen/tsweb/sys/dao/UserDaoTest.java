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
@ContextConfiguration(locations = "classpath:spring-*.xml")
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    private User user;

    @Before
    public void init() {
        this.user = new User("hayden", "hayden");
        this.userDao.addEntity(this.user);
    }
    
    @After
    public void clear() {
        this.userDao.deleteEntity(this.user);
    }
    
    @Test
    public void testUpdateEntity() {
        User tmp = this.user.clone();
        tmp.setUsername("name-cfg0523");
        tmp.setPassword("pwd-cfg0523");
        tmp.setRemark("test by cfg0523");
        this.userDao.updateEntity(tmp);
        
        tmp = this.userDao.getEntity(this.user.getId());
        Assert.assertEquals(this.user.getId(), tmp.getId());
        Assert.assertEquals("name-cfg0523", tmp.getUsername());
        Assert.assertEquals("pwd-cfg0523", tmp.getPassword());
        Assert.assertEquals("test by cfg0523", tmp.getRemark());
    }
    
}
