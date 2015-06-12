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
    
    private Operation operation;
    
    @Before
    public void init() {
        this.operation = new Operation("addUser", "添加用户").setId("addUserOperation");
        this.operation.setComponent(new Component().setId("C0"));
        this.operationDao.addEntity(this.operation);
    }
    
    @After
    public void clear() {
        this.operationDao.deleteEntity(this.operation);
    }
    
    @Test
    public void testGetById() {
        Operation tmp = this.operationDao.getById(this.operation.getId());
        
        Assert.assertNotNull(tmp);
        Assert.assertNotNull(this.operation.getComponent());
    }
    
}
