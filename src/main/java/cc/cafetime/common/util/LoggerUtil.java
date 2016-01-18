package cc.cafetime.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liujing on 16/1/3.
 */
public class LoggerUtil {
    /**
     * 从调用栈里获取调用的方法,返回Logger对象
     */
    public static Logger logger() {
        Logger logger = null;
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        String invoker = stack[2].getClassName();
        if (StringUtils.isEmpty(invoker)) {
            logger = LoggerFactory.getLogger(LoggerUtil.class);
        } else {
            Class clazz = null;
            try {
                clazz = Class.forName(invoker);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(clazz.getName());
            logger = LoggerFactory.getLogger(clazz);
        }
        return logger;
    }
}
