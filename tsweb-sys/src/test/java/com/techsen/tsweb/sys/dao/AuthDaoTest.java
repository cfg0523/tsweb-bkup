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
import com.techsen.tsweb.sys.domain.Auth;

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
        tmp.setAuthDesc("test-auth");
        this.authDao.updateEntity(tmp);
        tmp = this.authDao.getEntity(tmp.getId());
        
        System.out.println();
        System.out.println("tmp Auth: " + tmp);
        System.out.println();
        
        Assert.assertEquals("test-auth", tmp.getAuthDesc());
    }

    @Test
    public void testGetRoleByRole() {
        Auth tmp = new Auth();
        tmp.setId(this.auth.getId());
        Auth auth1 = this.authDao.getAuthByAuth(tmp);
        
        System.out.println();
        System.out.println("auth1 Auth: " + tmp);
        System.out.println();
        
        tmp.setId(null);
        tmp.setAuthName(this.auth.getAuthName());
        Auth auth2 = this.authDao.getAuthByAuth(tmp);
        
        System.out.println();
        System.out.println("auth2 Auth: " + tmp);
        System.out.println();
        
        Assert.assertEquals(auth1.getId(), auth2.getId());
        Assert.assertEquals(auth1.getAuthName(), auth2.getAuthName());
        Assert.assertEquals(auth1.getAuthDesc(), auth2.getAuthDesc());
    }
    
}
