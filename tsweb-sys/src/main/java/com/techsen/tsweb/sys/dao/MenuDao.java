package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Menu;

@LocalMyBatisDao
public interface MenuDao extends Dao<Menu> {

    /**
     * 根据父菜单Id取得直接子菜单 
     */
    public List<Menu> getSubMenusByParentId(String parentId);
    
    /**
     * 获取导航条的Brand菜单
     */
    public Menu getBrandMenu();

    /**
     * 根据路径获取菜单
     */
    public Menu getMenuByPath(String menuPath);
}
