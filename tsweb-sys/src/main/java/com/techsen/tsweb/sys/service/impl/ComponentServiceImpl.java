package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.ComponentDao;
import com.techsen.tsweb.sys.domain.Component;
import com.techsen.tsweb.sys.service.ComponentService;

@Service("componentService")
public class ComponentServiceImpl implements ComponentService {
    
    @Resource
    private ComponentDao componentDao;

    /**
     * 根据组件Id或componentName获取组件
     */
    @Override
    public Component getComponent(Component component) {
        return this.componentDao.getEntity(component);
    }

    /**
     * 新增组件
     */
    @Override
    public Component addComponent(Component component) {
        this.componentDao.addEntity(component);
        return component;
    }

    /**
     * 修改组件
     */
    @Override
    public void updateComponent(Component component) {
        this.componentDao.updateEntity(component);
    }

    /**
     * 删除组件
     */
    @Override
    public void deleteComponent(Component component) {
        this.componentDao.deleteEntity(component);
    }
    
}
