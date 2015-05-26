package com.techsen.tsweb.sys.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.domain.User;

/**
 * 访问本地数据库安全数据的Realm
 */
public class LocalRealm extends AuthorizingRealm {

    @Resource
    private UserDao userDao;

    /**
     * 处理用户授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        String username = (String) this.getAvailablePrincipal(principals);
        return null;
    }

    /**
     * 处理用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authToken) throws AuthenticationException {
        if (authToken instanceof UsernamePasswordToken) {
            UsernamePasswordToken token = (UsernamePasswordToken) authToken;
            String username = token.getUsername();
            String password = String.valueOf(token.getPassword());

            User user = this.userDao.getUserByName(username);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    return new SimpleAuthenticationInfo(user.getUsername(),
                            user.getPassword(), this.getName());
                } else {
                    throw new CredentialsException("密码不正确");
                }
            } else {
                throw new UnknownAccountException("用户不存在");
            }
        }
        return null;
    }

}
