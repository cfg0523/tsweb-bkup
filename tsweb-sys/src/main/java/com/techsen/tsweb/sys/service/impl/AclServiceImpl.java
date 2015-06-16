package com.techsen.tsweb.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.dao.AclDao;
import com.techsen.tsweb.sys.domain.Acl;
import com.techsen.tsweb.sys.service.AclService;

@Service
public class AclServiceImpl implements AclService {

    @Resource
    private AclDao aclDao;
    
    /**
     * 根据Acl的Id获取Acl
     */
    @Override
    public Acl getAcl(Acl acl) {
        return this.aclDao.getEntity(acl);
    }

    /**
     * 新增Acl
     */
    @Override
    public Acl addAcl(Acl acl) {
        this.aclDao.addEntity(acl);
        return acl;
    }

    /**
     * 更新Acl
     */
    @Override
    public void updateAcl(Acl acl) {
        this.aclDao.updateEntity(acl);
    }

    /**
     * 删除Acl
     */
    @Override
    public void deleteAcl(Acl acl) {
        this.aclDao.deleteEntity(acl);
    }

    /**
     * 根据角色名获取Acl集合
     */
    @Override
    public List<Acl> getAclsByRoleName(String roleName) {
        return this.aclDao.getAclsByRoleName(roleName);
    }

}
