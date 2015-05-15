package com.techsen.tsweb.sys.mapper;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/**/spring-beans.xml")
public class UserMapperTest {
    
    @Resource private UserDao userDao;

    @Test
    public void testGetEntity() {
        System.out.println("--------------------");
        System.out.println(userDao.getEntity("1"));
        System.out.println("--------------------");
    }
}
