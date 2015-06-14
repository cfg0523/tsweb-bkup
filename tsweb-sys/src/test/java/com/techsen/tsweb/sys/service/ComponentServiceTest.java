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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class ComponentServiceTest {

    @Resource
    private ComponentService componentService;

    private Component component;

    @Before
    public void init() {
        this.component = new Component("testComponent", "Controller");
        this.componentService.addComponent(this.component);
    }
    
    @After
    public void clear() {
        this.componentService.deleteComponent(this.component);
    }
    
    @Test
    public void testAddComponentAndUpdateComponent() {
        Component tmp = this.componentService.getComponent(this.component);
        Assert.assertNotNull(tmp);
        Assert.assertNotNull(tmp.getCreateDate());
        
        tmp.setDesc("testComponentDesc");
        this.componentService.updateComponent(tmp);
        
        Component tmp2 = this.componentService.getComponent(tmp);
        Assert.assertNotNull(tmp2);
        Assert.assertNotNull(tmp.getUpdateDate());
        Assert.assertEquals(tmp.getId(), tmp2.getId());
        Assert.assertEquals(tmp.getName(), tmp2.getName());
        Assert.assertEquals(tmp.getType(), tmp2.getType());
        Assert.assertEquals(tmp.getDesc(), tmp2.getDesc());
        
    }

}
