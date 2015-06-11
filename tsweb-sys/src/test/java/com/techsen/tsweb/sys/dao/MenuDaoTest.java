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

import com.techsen.tsweb.sys.domain.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring-*.xml")
public class MenuDaoTest {

    @Resource
    private MenuDao menuDao;

    private Menu menu;

    @Before
    public void init() {
        this.menu = new Menu("menu:test", "menu-test-desc").setId("M0")
                .setParent(new Menu().setId("M1"));
        this.menuDao.addEntity(this.menu);
    }

    @After
    public void clear() {
        this.menuDao.deleteEntity(this.menu);
    }

    @Test
    public void testGetEntity() {
        Menu tmp = this.menuDao.getEntity(this.menu);
        Assert.assertNotNull(tmp);

        Menu parent = tmp.getParent();
        Assert.assertNotNull(parent);

        Menu m1 = this.menuDao.getById(this.menu.getParent().getId());
        Assert.assertEquals(m1.getId(), parent.getId());
        Assert.assertEquals(m1.getName(), parent.getName());
        Assert.assertEquals(m1.getDesc(), parent.getDesc());
        Assert.assertEquals(m1.getPath(), parent.getPath());
        Assert.assertEquals(m1.getAclBit(), parent.getAclBit());
        
        List<Menu> subMenus = tmp.getSubMenus();
        System.out.println(subMenus);
    }

    @Test
    public void testUpdateEntity() {
        Menu menu = this.menu.clone();
        Menu parent = new Menu().setId("M2");
        menu.setDesc("menu:test:desc").setParent(parent);
        this.menuDao.updateEntity(menu);

        Menu tmp = this.menuDao.getEntity(menu);
        Assert.assertNotNull(tmp);

        Menu tmpParent = tmp.getParent();
        Assert.assertNotNull(tmpParent);

        Assert.assertEquals(menu.getDesc(), tmp.getDesc());
        Assert.assertEquals(parent.getId(), tmpParent.getId());
    }

}
