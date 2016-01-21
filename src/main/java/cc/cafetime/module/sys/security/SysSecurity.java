package cc.cafetime.module.sys.security;

import cc.cafetime.common.helper.DatabaseHelper;
import cc.cafetime.common.security.Security;
import cc.cafetime.common.util.CastUtil;

import java.util.Set;

/**
 * 应用安全控制
 * Created by liujing on 16/1/19.
 */
public class SysSecurity implements Security {

    @Override
    public String getPassword(String username) {
        String sql = " select password from user where username=? ";
        return DatabaseHelper.queryString(sql,username);
    }

    @Override
    public Set<String> getRoleNameSet(String username) {
        String sql = "select r.role_name from user u, user_role ur, role r where u.id=ur.user_id and r.id = ur.role_id and u.username=? ";
        return (Set<String>) DatabaseHelper.querySet(sql, username);
    }

    @Override
    public Set<String> getPermissionNameSet(String roleName) {
        String sql = " select p.permission_name from role r, role_permissionrp,permission p where r.id=rp.role_id and p.id=rp.permission_id and r_role_name=? ";
        return (Set<String>) DatabaseHelper.querySet(sql, roleName);
    }
}
