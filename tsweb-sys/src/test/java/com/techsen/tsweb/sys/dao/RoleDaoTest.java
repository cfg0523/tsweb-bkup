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
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class RoleDaoTest {

    @Resource
    private RoleDao roleDao;

    private Role role;

    @Before
    public void init() {
        this.role = new Role("testRole", "测试角色");
        this.role.setId(UUIDUtil.uuid());
        this.roleDao.addEntity(this.role);
    }

    @After
    public void clear() {
        this.roleDao.deleteEntity(this.role);
    }

    @Test
    public void testUpdateEntity() {
        Role tmp = this.role.clone();
        tmp.setDesc("test-role");
        this.roleDao.updateEntity(tmp);
        tmp = this.roleDao.getEntity(tmp);
        
        System.out.println();
        System.out.println("tmp Role: " + tmp);
        System.out.println();
        
        Assert.assertEquals("test-role", tmp.getDesc());
    }
    
    @Test
    public void testGetRoleByRole() {
        Role tmp = new Role();
        tmp.setId(this.role.getId());
        Role role1 = this.roleDao.getEntity(tmp);
        
        System.out.println();
        System.out.println("role1 Role: " + tmp);
        System.out.println();
        
        tmp.setId(null);
        tmp.setName(this.role.getName());
        Role role2 = this.roleDao.getEntity(tmp);
        
        System.out.println();
        System.out.println("role2 Role: " + tmp);
        System.out.println();
        
        Assert.assertEquals(role1.getId(), role2.getId());
        Assert.assertEquals(role1.getName(), role2.getName());
        Assert.assertEquals(role1.getDesc(), role2.getDesc());
    }

    @Test
    public void testGetRolesByUser() {
        List<Role> roles = this.roleDao.getRolesByUser(new User("hayden"));
        System.out.println();
        for (Role role : roles) {
            System.out.println(role);
        }
        System.out.println();
    }
    
}
