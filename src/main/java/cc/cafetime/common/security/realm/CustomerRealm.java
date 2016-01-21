package cc.cafetime.common.security.realm;

import cc.cafetime.common.security.Security;
import cc.cafetime.common.security.SecurityConstant;
import cc.cafetime.common.security.password.Md5CredentialsMatcher;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liujing on 16/1/20.
 */
public class CustomerRealm extends AuthorizingRealm {

    private final Security security;

    public CustomerRealm(Security security) {
        this.security = security;
        super.setName(SecurityConstant.REALMS_CUSTOM);
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if(principals==null){
            throw new AuthorizationException("Parameter principals is null ");
        }
        // 获取已认证用户的用户名
        String username = (String) super.getAvailablePrincipal(principals);

        // 通过 Security 接口并根据用户名获取角色名集合
        Set<String> roleNameSet = security.getRoleNameSet(username);

        //通过 Security 接口 并根据角色名获取与其对应的权限名集合
        Set<String> permissionNameSet = new HashSet<String>();
        if(CollectionUtils.isNotEmpty(roleNameSet)){
            for(String roleName : roleNameSet){
                Set<String> currentPermissionNameSet = security.getPermissionNameSet(roleName);
                permissionNameSet.addAll(currentPermissionNameSet);
            }
        }

        // 将角色名集合与权限名集合放入 AuthorizationInfo 对象中, 便于后续的授权操作
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleNameSet);
        authorizationInfo.setStringPermissions(permissionNameSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if(token == null){
            throw new AuthenticationException("Parameter token is null");
        }

        // 通过 AuthenticationToken 对象获取从表单中提交过来的用户名
        String username = ((UsernamePasswordToken) token).getUsername();

        // 通过 Security 接口并根据用户名获取数据库中存放的密码
        String password = security.getPassword(username);

        // 将用户名与密码放入 AuthenticatioInfo 对象中, 便于后续的认证操作
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        authenticationInfo.setPrincipals(new SimplePrincipalCollection(username, super.getName()));
        authenticationInfo.setCredentials(password);
        return authenticationInfo;
    }
}
