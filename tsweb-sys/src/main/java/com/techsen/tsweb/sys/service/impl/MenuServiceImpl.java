package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.MenuDao;
import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.service.MenuService;

@Service("menuService")
public class MenuServiceImpl extends BaseService<Menu, MenuDao> implements MenuService{

    @Override
    @Resource
    public void setDao(MenuDao dao) {
        this.dao = dao;
    }

    /**
     * 获取导航条的Brand菜单
     */
    @Override
    public Menu getBrandMenu() {
        return this.dao.getBrandMenu();
    }

    /**
     * 根据路径获取菜单
     */
    @Override
    public Menu getMenuByPath(String menuPath) {
        return this.dao.getMenuByPath(menuPath);
    }

}
