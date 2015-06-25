package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.domain.Menu;

public interface MenuService extends Service<Menu> {

    /**
     * 根据菜单资源类型获取菜单
     */
    List<Menu> getMenusByResourceType(String resourceType);
    
}
