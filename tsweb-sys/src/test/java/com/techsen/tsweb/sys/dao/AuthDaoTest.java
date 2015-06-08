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

import com.techsen.tsweb.core.util.UUIDUtil;
import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class AuthDaoTest {

    @Resource
    private AuthDao authDao;

    private Auth auth;

    @Before
    public void init() {
        this.auth = new Auth("auth:test", "测试权限");
        this.auth.setId(UUIDUtil.uuid());
        this.authDao.addEntity(this.auth);
    }

    @After
    public void clear() {
        this.authDao.deleteEntity(this.auth);
    }

    @Test
    public void testUpdateEntity() {
        Auth tmp = this.auth.clone();
        tmp.setDesc("test-auth");
        this.authDao.updateEntity(tmp);
        tmp = this.authDao.getEntity(tmp);
        
        System.out.println();
        System.out.println("tmp Auth: " + tmp);
        System.out.println();
        
        Assert.assertEquals("test-auth", tmp.getDesc());
    }

    @Test
    public void testGetAuthByAuth() {
        Auth tmp = new Auth();
        tmp.setId(this.auth.getId());
        Auth auth1 = this.authDao.getEntity(tmp);
        
        System.out.println();
        System.out.println("auth1 Auth: " + tmp);
        System.out.println();
        
        tmp.setId(null);
        tmp.setName(this.auth.getName());
        Auth auth2 = this.authDao.getEntity(tmp);
        
        System.out.println();
        System.out.println("auth2 Auth: " + tmp);
        System.out.println();
        
        Assert.assertEquals(auth1.getId(), auth2.getId());
        Assert.assertEquals(auth1.getName(), auth2.getName());
        Assert.assertEquals(auth1.getDesc(), auth2.getDesc());
    }
    
    @Test
    public void testGetAuthsByUser() {
        List<Auth> auths = this.authDao.getAuthsByUser(new User("hayden"));
        System.out.println();
        for (Auth auth : auths) {
            System.out.println(auth);
        }
        System.out.println();
    }
    
}
