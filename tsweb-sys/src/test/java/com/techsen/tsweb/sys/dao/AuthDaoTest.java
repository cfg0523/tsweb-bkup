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

import com.techsen.tsweb.sys.domain.Auth;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-*.xml")
public class AuthDaoTest {
    @Resource
    private AuthDao authDao;

    private Auth auth;

    @Before
    public void init() {
        this.auth = new Auth("auth:test");
        this.auth.setAuthDesc("auth test");
        this.authDao.addEntity(auth);
    }

    @After
    public void clear() {
        this.authDao.deleteEntity(this.auth);
    }

    @Test
    public void testUpdateEntity() {
        Auth tmp = this.auth.clone();
        tmp.setAuthName("auth:add");
        tmp.setAuthDesc("auth add");
        this.authDao.updateEntity(tmp);

        tmp = this.authDao.getEntity(this.auth.getId());
        Assert.assertEquals("auth:add", tmp.getAuthName());
        Assert.assertEquals("auth add", tmp.getAuthDesc());
    }

    @Test
    public void testGetAuthByName() {
        Auth tmp = this.authDao.getAuthByName("auth:test");
        Assert.assertEquals("auth:test", tmp.getAuthName());
        Assert.assertEquals("auth test", tmp.getAuthDesc());
    }
    
    @Test
    public void testGetAuthsByUserId() {
        String userId = "1";
        List<Auth> auths = this.authDao.getAuthsByUserId(userId);
        for (Auth auth : auths) {
            System.out.println(auth);
        }
    }
    
    @Test
    public void testGetAuthsByRoleId() {
        String roleId = "1";
        List<Auth> auths = this.authDao.getAuthsByRoleId(roleId);
        for (Auth auth : auths) {
            System.out.println(auth);
        }
    }
}
