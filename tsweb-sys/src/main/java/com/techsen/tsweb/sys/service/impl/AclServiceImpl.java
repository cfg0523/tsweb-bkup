package com.techsen.tsweb.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.Permission;
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
     * 根据角色名获取AclPermission集合
     */
    @Override
    public List<Permission> getAclPermissionsByRoleName(String roleName) {
        List<Permission> retList = new ArrayList<Permission>();
        List<Acl> aclList = this.aclDao.getAclsByRoleName(roleName);
        for (Acl acl : aclList) {
            retList.add(acl.toAclPermission());
        }
        return retList;
    }

    /**
     * 根据用户民名获取AclPermission集合
     */
    @Override
    public List<Permission> getAclPermissionByUserName(String userName) {
        List<Permission> retList = new ArrayList<Permission>();
        List<Acl> aclList = this.aclDao.getAclsByUserName(userName);
        for (Acl acl : aclList) {
            retList.add(acl.toAclPermission());
        }
        return retList;
    }

}
