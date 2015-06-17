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
import com.techsen.tsweb.sys.domain.Operation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class OperationDaoTest {

    @Resource
    private OperationDao operationDao;
    
    @Resource
    private ComponentDao componentDao;
    
    private Component component;
    private Operation operation;
    
    @Before
    public void init() {
        this.component = new Component("testComponent", "testComponent").setId("C0");
        this.componentDao.addEntity(this.component);
        
        this.operation = new Operation("addUser", "添加用户").setId("addUserOperation");
        this.operation.setComponent(this.component);
        this.operationDao.addEntity(this.operation);
    }
    
    @After
    public void clear() {
        this.operationDao.deleteEntity(this.operation);
        this.componentDao.deleteEntity(this.component);
    }
    
    @Test
    public void testGetById() {
        Operation tmp = this.operationDao.getById(this.operation.getId());
        
        Assert.assertNotNull(tmp);
        Assert.assertNotNull(this.operation.getComponent());
    }
    
    @Test
    public void testUpdateEntity() {
        Operation tmp = this.operation.clone().setDesc("addUser");
        this.operationDao.updateEntity(tmp);
        
        Operation tmp2 = this.operationDao.getEntity(tmp);
        
        Assert.assertNotNull(tmp2);
        Assert.assertEquals(tmp.getId(), tmp2.getId());
        Assert.assertEquals(tmp.getName(), tmp2.getName());
        Assert.assertEquals(tmp.getDesc(), tmp2.getDesc());
        Assert.assertNotNull(tmp2.getComponent());
        Assert.assertEquals(tmp.getComponent().getId(), tmp2.getComponent().getId());
    }
    
    @Test
    public void testGetOperationByComponentAndOperationName(){
        Operation operation = this.operationDao.getOperationByComponentAndOperationName("sys", "main", "main");
        System.out.println();
        System.out.println(operation.getName());
        System.out.println(operation.getAclPos());
        System.out.println();
    }
    
}
