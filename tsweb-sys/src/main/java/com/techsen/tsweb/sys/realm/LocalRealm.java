package com.techsen.tsweb.sys.realm;

import static com.techsen.tsweb.core.util.ValidUtil.isValid;

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

import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.AuthService;
import com.techsen.tsweb.sys.service.RoleService;
import com.techsen.tsweb.sys.service.UserService;

/**
 * 访问本地数据库安全数据的Realm
 */
public class LocalRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private AuthService authService;

    /**
     * 处理用户授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        SimpleAuthorizationInfo authzInfo = new SimpleAuthorizationInfo();

        String userId = (String) this.getAvailablePrincipal(principals);
        User user = this.userService.getUser(new User().setId(userId));

        if (user != null) {
            // 获取用户角色
            List<Role> roles = user.getRoles() != null ? user.getRoles()
                    : this.roleService.getRolesByUser(user);
            if (isValid(roles)) {
                for (Role role : roles) {
                    String roleName = role.getRoleName();
                    authzInfo.addRole(roleName);
                }
            }

            // 获取用户权限
            List<Auth> auths = user.getAuths() != null ? user.getAuths()
                    : this.authService.getAuthsByUser(user);
            if (isValid(auths)) {
                for (Auth auth : auths) {
                    String authName = auth.getAuthName();
                    authzInfo.addStringPermission(authName);
                }
            }
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

        User user = this.userService.getUser(new User(username));
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return new SimpleAuthenticationInfo(user.getId(), username
                        + ":" + password, this.getName());
            } else {
                throw new CredentialsException("用户名或密码错误");
            }
        } else {
            throw new UnknownAccountException("用户不存在");
        }
    }

}
