package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.domain.Menu;

public interface MenuService extends Service<Menu> {

    /**
     * 获取导航条的Brand菜单
     */
    public Menu getBrandMenu();
    
    /**
     * 根据路径获取菜单
     */
    public Menu getMenuByPath(String menuPath);
    
}
