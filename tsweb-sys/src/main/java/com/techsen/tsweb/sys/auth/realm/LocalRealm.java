package com.techsen.tsweb.sys.auth.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.techsen.tsweb.sys.dao.AclDao;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.domain.User;

/**
 * 访问本地数据库安全数据的Realm
 */
@Component("localRealm")
public class LocalRealm extends AuthorizingRealm {

    @Resource
    private UserDao userDao;

    @Resource
    private AclDao aclDao;
    
    /**
     * 处理用户授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        SimpleAuthorizationInfo authzInfo = new SimpleAuthorizationInfo();

        String userId = (String) this.getAvailablePrincipal(principals);
        User user = this.userDao.getEntity(new User().setId(userId));
        
        return authzInfo;
    }

    /**
     * 处理用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        User user = this.userDao.getEntity(new User(username));
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return new SimpleAuthenticationInfo(user.getId(), password,
                        this.getName());
            } else {
                throw new CredentialsException("用户名或密码错误");
            }
        } else {
            throw new UnknownAccountException("用户不存在");
        }
    }

}
