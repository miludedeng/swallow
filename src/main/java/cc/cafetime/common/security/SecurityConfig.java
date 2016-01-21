package cc.cafetime.common.security;

import cc.cafetime.common.helper.ConfigHelper;
import cc.cafetime.common.util.ReflectionUtil;
import cc.cafetime.common.security.Security;

/**
 * 从配置文件中获取相关属性
 * Created by liujing on 16/1/20.
 */
public final class SecurityConfig {

    public static String getRealms(){
        return ConfigHelper.getString(SecurityConstant.REALMS);
    }

    public static Security getSecurity(){
        String className = ConfigHelper.getString(SecurityConstant.SECUTIRY_CLASS);
        return (Security) ReflectionUtil.newInstance(className);
    }

    public static String getJdbcAuthcQuery(){
        return ConfigHelper.getString(SecurityConstant.JDBC_AUTHC_QUERY);
    }

    public static String getJdbcRolesQuery(){
        return ConfigHelper.getString(SecurityConstant.JDBC_ROLES_QUERY);
    }

    public static String getJdbcPermissionQuery(){
        return ConfigHelper.getString(SecurityConstant.JDBC_PERMISSIONS_QUERY);
    }

    public static boolean isCacheable(){
        return ConfigHelper.getBoolean(SecurityConstant.CACHE);
    }

}
