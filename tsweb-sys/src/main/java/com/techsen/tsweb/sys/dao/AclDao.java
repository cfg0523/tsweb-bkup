package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Acl;

@LocalMyBatisDao
public interface AclDao extends Dao<Acl> {

    public List<Acl> getAclsByRoleName(String roleName);
    
    public List<Acl> getAclsByUserName(String userName);
}
