package com.techsen.tsweb.sys.service;

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

}
