package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Acl;

@LocalMyBatisDao
public interface AclDao extends Dao<Acl> {

    /**
     * 根据角色名获取Acl集合
     */
    public List<Acl> getAclsByRoleName(String roleName);
    
    /**
     * 根据用户名获取Acl集合
     */
    public List<Acl> getAclsByUsername(String username);
    
}
