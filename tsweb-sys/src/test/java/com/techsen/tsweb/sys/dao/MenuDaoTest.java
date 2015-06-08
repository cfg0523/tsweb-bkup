package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class MenuDaoTest {
    
    @Resource
    private MenuDao menuDao;
    
    private Menu menu;
    
    @Before
    public void init() {
        this.menu = new Menu("/sys/dept", "部门管理").setId("menutest");
        this.menuDao.addEntity(this.menu);
    }
    
    @After
    public void clear() {
        this.menuDao.deleteEntity(this.menu);
    }
    
    @Test
    public void testUpdateEntity() {
        Menu tmp = this.menu.clone();
        tmp.setId(null).setParent("M0");
        this.menuDao.updateEntity(tmp);
        tmp = this.menuDao.getEntity(this.menu);
        
        System.out.println();
        System.out.println("tmp: " + tmp);
        System.out.println();
        
        Assert.assertEquals(this.menu.getId(), tmp.getId());
        Assert.assertEquals(this.menu.getPath(), tmp.getPath());
        Assert.assertEquals(this.menu.getName(), tmp.getName());
        Assert.assertEquals("M0", tmp.getParent());
    }
    
}
