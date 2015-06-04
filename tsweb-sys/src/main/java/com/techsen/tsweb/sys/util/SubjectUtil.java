package com.techsen.tsweb.sys.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;

import com.techsen.tsweb.core.util.SpringContextUtil;

public class SubjectUtil {
    
    static {
        SecurityUtils.setSecurityManager(SpringContextUtil.getBean(SecurityManager.class));
    }
    
    /**
     * 获取登录用户的唯一标识<br/>
     * 在LocalRealm中用户的唯一标识为用户的id
     */
    public static String getPrincipal() {
        return (String) SecurityUtils.getSubject().getPrincipal();
    }
    
}
