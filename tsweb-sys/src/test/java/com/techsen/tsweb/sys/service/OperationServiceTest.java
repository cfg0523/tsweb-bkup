package com.techsen.tsweb.sys.service;

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
public class OperationServiceTest {

    @Resource
    private OperationService operationService;

    private Operation operation;

    @Before
    public void init() {
        this.operation = new Operation("testOperation", "testOperationDesc")
                .setComponent(new Component().setId("C0"));
        this.operationService.addOperation(this.operation);
    }

    @After
    public void clear() {
        this.operationService.deleteOperation(this.operation);
    }

    @Test
    public void testAddOperationAndUpdateOperation() {
        Operation tmp = this.operation.clone();
        
        Assert.assertNotNull(tmp);
        Assert.assertNotNull(tmp.getId());
        Assert.assertNotNull(tmp.getCreateDate());

        tmp.setDesc("testDesc").setAclBit(0x01);
        this.operationService.updateComponent(tmp);

        Operation tmp2 = this.operationService.getOperation(tmp);
        Assert.assertNotNull(tmp2);
        Assert.assertEquals(tmp.getId(), tmp2.getId());
        Assert.assertEquals(tmp.getName(), tmp2.getName());
        Assert.assertEquals(tmp.getDesc(), tmp2.getDesc());
        Assert.assertEquals(tmp.getAclBit(), tmp2.getAclBit());
    }

}
