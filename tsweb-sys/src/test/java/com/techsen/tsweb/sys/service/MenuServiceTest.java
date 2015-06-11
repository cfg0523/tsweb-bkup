package com.techsen.tsweb.sys.service;

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
public class MenuServiceTest {

    @Resource
    private MenuService menuService;
    
    private Menu menu;
    
    @Before
    public void init() {
        this.menu = new Menu("menu:test", "menu-test");
        this.menuService.addMenu(this.menu);
    }
    
    @After
    public void clear() {
        this.menuService.deleteMenu(this.menu);
    }
    
    @Test
    public void testAddMenuAndGetMenu() {
        Menu tmp = this.menuService.getMenu(this.menu);
        
        Assert.assertNotNull(tmp);
        Assert.assertNotNull(tmp.getCreateDate());
        
        Assert.assertEquals(this.menu.getId(), tmp.getId());
        Assert.assertEquals(this.menu.getName(), tmp.getName());
        Assert.assertEquals(this.menu.getDesc(), tmp.getDesc());
    }
    
}
