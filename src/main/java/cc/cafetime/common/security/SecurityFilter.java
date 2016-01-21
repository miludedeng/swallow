package cc.cafetime.common.security;

import cc.cafetime.common.security.realm.AppJdbcRealm;
import cc.cafetime.common.security.realm.CustomerRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.CachingSecurityManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 安全过滤器
 * Created by liujing on 16/1/20.
 */
public class SecurityFilter extends ShiroFilter {

    @Override
    public void init() throws Exception {
        super.init();
        WebSecurityManager webSecurityManager = super.getSecurityManager();
        // 设置 Realm, 可同时支持多个 Realm, 并按照顺序用逗号分割
        setRealms(webSecurityManager);
        // 设置 Cache, 用于减少数据库查询次数
        setCache(webSecurityManager);
    }

    private void setRealms(WebSecurityManager webSecurityManager) {
        // 读取配置项
        String securityRealms = SecurityConfig.getRealms();
        if (securityRealms != null) {
            //根据逗号拆分
            String[] securityRealmArray = securityRealms.split(",");
            if (securityRealmArray.length > 0) {
                // 使 Realm 具备唯一性与顺序性
                Set<Realm> realms = new LinkedHashSet<Realm>();
                for (String securityRealm : securityRealmArray) {
                    if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_JDBC)) {
                        // 添加基于 JDBC 的 Realm, 需配置相关的 SQL 查询语句
                        addJdbcRealm(realms);
                    } else if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_CUSTOM)) {
                        // 添加基于定制化的 Realm, 需要实现 SmartSecurity 接口
                        addCustomRealm(realms);
                    }
                }
                RealmSecurityManager realmSecurityManager = (RealmSecurityManager) webSecurityManager;
                realmSecurityManager.setRealms(realms);
            }

        }
    }

    private void addCustomRealm(Set<Realm> realms) {
        // 读取 security.custom.class 配置性
        Security security = SecurityConfig.getSecurity();
        // 添加 Realm 的实现类
        CustomerRealm customerRealm = new CustomerRealm(security);
        realms.add(customerRealm);
    }

    private void addJdbcRealm(Set<Realm> realms) {
        // 添加基于 JDBC 的 Ream
        AppJdbcRealm jdbcRealm = new AppJdbcRealm();
        realms.add(jdbcRealm);
    }

    private void setCache(WebSecurityManager webSecurityManager) {
        // 读取 security.cache 配置项
        if(SecurityConfig.isCacheable()){
            CachingSecurityManager cachingSecurityManager = (CachingSecurityManager) webSecurityManager;
            // 使用基于内存的 CacheManager
            CacheManager cacheManager = new MemoryConstrainedCacheManager();
            cachingSecurityManager.setCacheManager(cacheManager);
        }
    }

}
