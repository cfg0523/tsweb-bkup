package com.techsen.tsweb.sys.mapper;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.core.util.UUIDUtil;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/**/spring-beans.xml")
public class UserMapperTest {
    
    @Resource private UserDao userDao;

    @Test
    public void testGetEntity() {
        System.out.println(userDao.getEntity("1"));
    }
    
    @Test
    public void testAddEntity() {
        User user = new User();
        
        user.setId(UUIDUtil.uuid());
        user.setUsername("cfg0523");
        user.setPassword("qiannianhu");
        user.setRemark("test");
        
        userDao.addEntity(user);
    }
    
    @Test
    public void testUpdateEntity() {
        User user = new User();
        
        user.setId("f0e731ed841c4e77866a9e31580eef57");
        user.setUsername("cfg0523");
        user.setPassword("qiannianhu");
        user.setRemark("test by hayden");
        
        userDao.updateEntity(user);
    }
    
    @Test
    public void testDeleteEntity() {
        User user = new User();
        
        user.setId("f0e731ed841c4e77866a9e31580eef57");
        
        userDao.deleteEntity(user);
    }
}
