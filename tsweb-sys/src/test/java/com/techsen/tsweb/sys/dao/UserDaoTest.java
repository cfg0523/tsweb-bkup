package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.core.util.UUIDUtil;
import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class UserDaoTest {

    @Resource
    private UserDao userDao;
    
    private User user;
    
    @Before
    public void init() {
        this.user = new User("cfg0523", "cfg0523");
        this.user.setId(UUIDUtil.uuid());
        this.userDao.addEntity(this.user);
    }
    
    @After
    public void clear() {
        this.userDao.deleteEntity(this.user);
    }
    
    @Test
    public void testUpdateEntity() {
        User tmp = this.user.clone();
        tmp.setPassword("hayden");
        this.userDao.updateEntity(tmp);
        tmp = this.userDao.getEntity(tmp.getId());
        
        System.out.println();
        System.out.println("tmp User: " + tmp);
        System.out.println();
        
        Assert.assertEquals("hayden", tmp.getPassword());
    }
    
    @Test
    public void testGetUserByUser() {
        User tmp = new User();
        tmp.setId(this.user.getId());
        User user1 = this.userDao.getUserByUser(tmp);
        
        System.out.println();
        System.out.println("user1 User: " + user1);
        System.out.println();
        
        tmp.setId(null);
        tmp.setUsername(this.user.getUsername());
        User user2 = this.userDao.getUserByUser(tmp);

        System.out.println();
        System.out.println("user2 User: " + user2);
        System.out.println();
        
        Assert.assertEquals(user1.getId(), user2.getId());
        Assert.assertEquals(user1.getUsername(), user2.getUsername());
        Assert.assertEquals(user1.getPassword(), user2.getPassword());
    }
    
}
