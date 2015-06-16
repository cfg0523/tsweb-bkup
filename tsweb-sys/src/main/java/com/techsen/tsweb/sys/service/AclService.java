package com.techsen.tsweb.sys.service;

import java.util.List;

import org.apache.shiro.authz.Permission;

import com.techsen.tsweb.sys.domain.Acl;

public interface AclService {

    /**
     * 根据Acl的Id获取Acl
     */
    public Acl getAcl(Acl acl);

    /**
     * 新增Acl
     */
    public Acl addAcl(Acl acl);
    
    /**
     * 更新Acl
     */
    public void updateAcl(Acl acl);

    /**
     * 删除Acl
     */
    public void deleteAcl(Acl acl);

    /**
     * 根据角色名获取AclPermission集合
     */
    public List<Permission> getAclPermissionsByRoleName(String roleName);
    
    /**
     * 根据用户民名获取AclPermission集合
     */
    public List<Permission> getAclPermissionByUserName(String userName);
}
