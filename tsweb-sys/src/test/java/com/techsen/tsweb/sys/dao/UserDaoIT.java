package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-*.xml")
public class UserDaoIT {
    @Resource UserDao userDao;
    
    @Test
    public void testGetEntity() {
        User user = this.userDao.getEntity("1");
        Assert.assertEquals("1", user.getId());
        Assert.assertEquals("hayden", user.getUsername());
        Assert.assertEquals("chenchen", user.getPassword());
        Assert.assertEquals("1", user.getCreateBy());
        Assert.assertEquals("1", user.getUpdateBy());
        Assert.assertEquals("test", user.getRemark());
    }
}
