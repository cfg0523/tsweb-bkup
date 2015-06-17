package com.techsen.tsweb.sys.auth.realm;

import java.util.List;

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

import com.techsen.tsweb.sys.auth.AclPermission;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.AclService;
import com.techsen.tsweb.sys.service.UserService;

/**
 * 访问本地数据库安全数据的Realm
 */
@Component("localRealm")
public class LocalRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    
    @Resource
    private AclService aclService;
    
    /**
     * 处理用户授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        SimpleAuthorizationInfo authzInfo = new SimpleAuthorizationInfo();

        String userId = (String) this.getAvailablePrincipal(principals);
        User user = this.userService.getEntity(new User().setId(userId));
        
        /**
         * 设置用户拥有的权限
         */
        for (Role role : user.getRoles()) {
            authzInfo.addRole(role.getName());
        }
        
        /**
         * 设置用户直接拥有的权限
         */
        List<AclPermission> aclPermissions = this.aclService.getAclPermissionsByUsername(user.getUsername());
        for (AclPermission aclPermission : aclPermissions) {
            authzInfo.addObjectPermission(aclPermission);
        }
        
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

        User user = this.userService.getEntity(new User(username));
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
