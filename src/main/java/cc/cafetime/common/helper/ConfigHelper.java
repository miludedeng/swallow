package cc.cafetime.common.helper;

import cc.cafetime.common.ConfigConstant;
import cc.cafetime.common.util.PropsUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Properties;

/**
 * 属性文件助手类
 * Created by liujing on 16/1/9.
 */
public class ConfigHelper {

    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取jdbc驱动
     */
    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取JDBC URL
     */
    public static String getJdbcUrl() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     * 获取JDBC 用户名
     */
    public static String getJdbcUserName() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取JDBC密码
     */
    public static String getJdbcPassword() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础报名
     */
    public static String getAppBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取应用JSP路径
     */
    public static String getAppJspPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH);
    }

    /**
     * 获取应用静态资源路径
     */
    public static String getAppAssetPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH);
    }

    /**
     * 获取上传文件大小限制
     */
    public static int getAppUploadLimit() {
        return NumberUtils.toInt(PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_UPLOAD_LIMIT), 0);
    }

    /**
     * 获取首页路径
     */
    public static String getAppIndexPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_INDEX_PATH);
    }

    /**
     * 根据 key 获取 String 型值
     */
    public static String getString(String key) {
        return PropsUtil.getString(CONFIG_PROPS, key);
    }

    /**
     * 根据 key 获取 Boolean 型值
     */
    public static boolean getBoolean(String key) {
        return PropsUtil.getBoolean(CONFIG_PROPS, key);
    }
}
