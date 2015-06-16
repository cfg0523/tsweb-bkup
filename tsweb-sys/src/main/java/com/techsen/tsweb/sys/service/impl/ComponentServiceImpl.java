package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.auth.AuthComponentType;
import com.techsen.tsweb.sys.auth.annotation.AuthComponent;
import com.techsen.tsweb.sys.auth.annotation.AuthOperation;
import com.techsen.tsweb.sys.dao.ComponentDao;
import com.techsen.tsweb.sys.domain.Component;
import com.techsen.tsweb.sys.service.ComponentService;

@Service("componentService")
@AuthComponent(name = "ComponentService", desc = "组件资源操作服务", type = AuthComponentType.Service)
public class ComponentServiceImpl implements ComponentService {

    @Resource
    private ComponentDao componentDao;

    /**
     * 根据组件Id或name获取组件
     */
    @Override
    @AuthOperation(aclBit = 0x01, desc = "根据组件Id或name获取组件")
    public Component getComponent(Component component) {
        return this.componentDao.getEntity(component);
    }

    /**
     * 新增组件
     */
    @Override
    @AuthOperation(aclBit = 0x02, desc = "新增组件")
    public Component addComponent(Component component) {
        this.componentDao.addEntity(component);
        return component;
    }

    /**
     * 修改组件
     */
    @Override
    @AuthOperation(aclBit = 0x03, desc = "修改组件")
    public void updateComponent(Component component) {
        this.componentDao.updateEntity(component);
    }

    /**
     * 删除组件
     */
    @Override
    @AuthOperation(aclBit = 0x04, desc = "删除组件")
    public void deleteComponent(Component component) {
        this.componentDao.deleteEntity(component);
    }

    /**
     * 删除所有组件
     */
    @Override
    @AuthOperation(aclBit = 0x05, desc = "删除所有组件")
    public void removeAll() {
        this.componentDao.removeAll();
    }

}
