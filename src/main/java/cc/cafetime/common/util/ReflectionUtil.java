package cc.cafetime.common.util;

/**
 * Created by liujing on 16/1/10.
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具类
 */
public class ReflectionUtil {

    /**
     * 创建实例
     */
    public static Object newInstance(String className) {
        try {
            Class clazz = Class.forName(className);
            return newInstance(clazz);
        } catch (ClassNotFoundException e) {
            LoggerUtil.logger().error(" new Instance by class name failure",e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建实例
     */
    public static Object newInstance(Class<?> clazz) {
        Object instance;
        try {
            instance = clazz.newInstance();
        } catch (Exception e) {
            LoggerUtil.logger().error("new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception e) {
            LoggerUtil.logger().error("invoke method failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量
     */
    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            LoggerUtil.logger().error("set field failure", e);
            throw new RuntimeException(e);
        }
    }
}
