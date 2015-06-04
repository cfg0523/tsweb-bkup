package com.techsen.tsweb.sys.util;

import org.apache.shiro.SecurityUtils;

public class UserUtil {
    
    /**
     * 获取登录用户的唯一标识<br/>
     * 在LocalRealm中用户的唯一标识为用户的id
     */
    public static String getPrincipal() {
        return (String) SecurityUtils.getSubject().getPrincipal();
    }
    
}
