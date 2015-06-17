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
    
}
