package cc.cafetime.common.helper;

import cc.cafetime.common.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean 助手类
 * Created by liujing on 16/1/10.
 */
public final class BeanHelper {

    /**
     * 定义Bean映射 (用于存放Bean类与Bean实例的映射关系)
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet){
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 设置 Bean 实例
     */
    public static void setBean(Class<?> clazz, Object obj){
        BEAN_MAP.put(clazz, obj);
    }

    /**
     * 获取 Bean 映射
     */
    public static Map<Class<?>, Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * 获取 Bean 实例
     */
    public static <T> T getBean(Class<T> clazz){
        if(!BEAN_MAP.containsKey(clazz)){
           throw new RuntimeException("can not get bean by class: "+clazz);
        }
        return (T) BEAN_MAP.get(clazz);
    }

}
