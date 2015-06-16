package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.auth.AuthComponentType;
import com.techsen.tsweb.sys.auth.annotation.AuthComponent;
import com.techsen.tsweb.sys.auth.annotation.AuthOperation;
import com.techsen.tsweb.sys.dao.MenuDao;
import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.service.MenuService;

@Service("menuService")
@AuthComponent(name = "MenuService", desc = "菜单操作服务", type = AuthComponentType.Service)
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     * 根据菜单Id或name获取Menu
     */
    @Override
    @AuthOperation(aclBit = 0x01, desc = "根据菜单Id或name获取Menu")
    public Menu getMenu(Menu menu) {
        return this.menuDao.getEntity(menu);
    }

    /**
     * 新增菜单
     */
    @Override
    @AuthOperation(aclBit = 0x02, desc = "新增菜单")
    public Menu addMenu(Menu menu) {
        this.menuDao.addEntity(menu);
        return menu;
    }

    /**
     * 修改菜单
     */
    @Override
    @AuthOperation(aclBit = 0x03, desc = "修改菜单")
    public void updateMenu(Menu menu) {
        this.menuDao.updateEntity(menu);
    }

    /**
     * 删除菜单
     */
    @Override
    @AuthOperation(aclBit = 0x04, desc = "删除菜单")
    public void deleteMenu(Menu menu) {
        this.menuDao.deleteEntity(menu);
    }

}
