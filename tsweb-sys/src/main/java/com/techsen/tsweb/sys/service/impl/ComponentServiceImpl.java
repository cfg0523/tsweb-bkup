package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.ComponentDao;
import com.techsen.tsweb.sys.domain.Component;
import com.techsen.tsweb.sys.service.ComponentService;

@Service("componentService")
public class ComponentServiceImpl extends BaseService<Component, ComponentDao>
        implements ComponentService {

    @Override
    @Resource
    public void setDao(ComponentDao dao) {
        this.dao = dao;
    }

    /**
     * 删除所有组件资源
     */
    public void remoteAll() {
        this.dao.removeAll();
    }
    
}
