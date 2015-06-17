package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.domain.Component;

public interface ComponentService extends Service<Component> {

    /**
     * 删除所有组件资源
     */
    public void remoteAll();
    
}
