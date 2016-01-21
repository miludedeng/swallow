package cc.cafetime.common.security;

/**
 * 安全 常量接口
 * Created by liujing on 16/1/20.
 */
public interface SecurityConstant {

    String REALMS = "security.realms";
    String REALMS_JDBC="jdbc";
    String REALMS_CUSTOM = "custom";

    String SECUTIRY_CLASS = "security.custom.class";

    String JDBC_AUTHC_QUERY ="security.jdbc.authc_query";
    String JDBC_ROLES_QUERY = "security.jdbc.roles_query";
    String JDBC_PERMISSIONS_QUERY = "security.jdbc.permissions_query";

    String CACHE="security.cache";

}
