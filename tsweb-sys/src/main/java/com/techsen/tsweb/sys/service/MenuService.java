package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.sys.domain.Menu;

/**
 * 菜单服务
 */
public interface MenuService {

    /**
     * 根据用户Id或menuName获取Menu
     */
    public Menu getMenu(Menu menu);

    /**
     * 新增用户
     */
    public Menu addMenu(Menu menu);

    /**
     * 修改用户
     */
    public void updateMenu(Menu menu);

    /**
     * 删除用户
     */
    public void deleteMenu(Menu menu);

}
