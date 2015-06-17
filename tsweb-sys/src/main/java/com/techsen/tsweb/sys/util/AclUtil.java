package com.techsen.tsweb.sys.util;

import java.util.ArrayList;
import java.util.List;

import com.techsen.tsweb.sys.auth.AclPermission;
import com.techsen.tsweb.sys.domain.Acl;

public class AclUtil {

    public static List<AclPermission> convert(List<Acl> acls) {
        List<AclPermission> retVal = new ArrayList<AclPermission>();
        for (Acl acl : acls) {
            retVal.add(acl.toAclPermission());
        }
        return retVal;
    }
    
}
