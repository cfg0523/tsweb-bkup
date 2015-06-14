package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.sys.domain.Component;

public interface ComponentService {

    /**
     * 根据组件Id或componentName获取组件
     */
    public Component getComponent(Component component);
    
    /**
     * 新增组件
     */
    public Component addComponent(Component component);
    
    /**
     * 修改组件
     */
    public void updateComponent(Component component);
    
    /**
     * 删除组件
     */
    public void deleteComponent(Component component);
    
}
