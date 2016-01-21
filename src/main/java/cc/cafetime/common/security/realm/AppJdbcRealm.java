package cc.cafetime.common.security.realm;

import cc.cafetime.common.helper.DatabaseHelper;
import cc.cafetime.common.security.SecurityConfig;
import cc.cafetime.common.security.password.Md5CredentialsMatcher;
import org.apache.shiro.realm.jdbc.JdbcRealm;

/**
 * 应用的 Jdbc Realm ( 需要提供相关 security.jdbc.* 配置项 )
 * Created by liujing on 16/1/20.
 */
public class AppJdbcRealm extends JdbcRealm {

    public AppJdbcRealm(){
        super.setDataSource(DatabaseHelper.getDataSource());
        super.setAuthenticationQuery(SecurityConfig.getJdbcAuthcQuery());
        super.setUserRolesQuery(SecurityConfig.getJdbcRolesQuery());
        super.setPermissionsQuery(SecurityConfig.getJdbcPermissionQuery());
        super.setPermissionsLookupEnabled(true);
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }
}
