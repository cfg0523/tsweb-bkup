package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.Component;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class ComponentDaoTest {
    
    @Resource
    private ComponentDao componentDao;
    
    private Component component;
    
    @Before
    public void init() {
        this.component = new Component("userController", "controller").setId("usercontroller");
        this.componentDao.addEntity(this.component);
    }
    
    @After
    public void clear() {
        this.componentDao.deleteEntity(this.component);
    }
    
    @Test
    public void testGetById() {
        Component tmp = this.componentDao.getById(this.component.getId());
        
        Assert.assertNotNull(tmp);
        Assert.assertEquals(0, tmp.getOperations().size());
    }
    
    @Test
    public void testUpdateEntity() {
        Component tmp = this.component.clone();
        tmp.setDesc("userController");
        this.componentDao.updateEntity(tmp);
        Component tmp2 = this.componentDao.getEntity(tmp);
        
        Assert.assertNotNull(tmp);
        Assert.assertEquals(tmp.getId(), tmp2.getId());
        Assert.assertEquals(tmp.getName(), tmp2.getName());
        Assert.assertEquals(tmp.getDesc(), tmp2.getDesc());
    }
}
