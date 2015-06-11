package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.MenuDao;
import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;
    
    /**
     * 根据菜单Id或menuName获取Menu
     */
    @Override
    public Menu getMenu(Menu menu) {
        return this.menuDao.getEntity(menu);
    }

    /**
     * 新增菜单
     */
    @Override
    public Menu addMenu(Menu menu) {
        this.menuDao.addEntity(menu);
        return menu;
    }

    /**
     * 修改菜单
     */
    @Override
    public void updateMenu(Menu menu) {
        this.menuDao.updateEntity(menu);
    }

    /**
     * 删除菜单
     */
    @Override
    public void deleteMenu(Menu menu) {
        this.menuDao.deleteEntity(menu);
    }
    
}
