package cc.cafetime.common.util;


/**
 * 字符串工具类
 * Created by liujing on 16/1/18.
 */
public class StringUtils {
    /**
     * 字符串工具类
     */
    public static final String SEPARATOR = String.valueOf((char) 29);
    public static final String CHAR_SET_UTF8 = "utf-8";

    /**
     * 判断字符串是否为空
     */
    public static boolean isNotEmpty(String str) {
        return str!=null&&!"".equals(str);
    }

    public static String[] splitString(String body, String s) {
        return body.split(s);
    }
}
