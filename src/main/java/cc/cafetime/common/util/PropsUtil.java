package cc.cafetime.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by liujing on 16/1/3.
 */
public class PropsUtil {

    /**
     * 加载属性文件
     */
    public static Properties loadProps(String filename) {
        Properties props = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            if (is == null) {
                throw new FileNotFoundException(filename + "file is not found");
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            LoggerUtil.logger().error("load properties file failure", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LoggerUtil.logger().error("close input stream failure", e);
                }
            }
        }
        return props;
    }

    /**
     * 获取字符型属性 ( 默认值为空字符串 )
     */
    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    /**
     * 获取字符型属性 ( 可指定默认值 )
     */
    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.containsKey(key)) {
            value = props.getProperty(key);
        }
        return value;
    }

    /**
     * 获取数值型属性 ( 默认值为0 )
     */
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }

    /**
     * 获取数值型属性 ( 可指定默认值 )
     */
    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.contains(key)) {
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    /**
     * 获取布尔型属性 ( 默认值为fale )
     */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

    /**
     * 获取布尔型属性 ( 可指定默认值 )
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.contains(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }

}
