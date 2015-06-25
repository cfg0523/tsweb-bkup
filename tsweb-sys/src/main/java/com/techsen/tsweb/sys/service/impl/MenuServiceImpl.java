package com.techsen.tsweb.sys.service.impl;

import java.util.List;

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
     * 根据菜单资源类型获取菜单
     */
    @Override
    public List<Menu> getMenusByResourceType(String resourceType) {
        return this.dao.getMenusByResourceType(resourceType);
    }

}
