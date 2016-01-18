package cc.cafetime.common.helper;

import cc.cafetime.common.annotation.Service;
import cc.cafetime.common.annotation.Controller;
import cc.cafetime.common.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liujing on 16/1/9.
 */
public final class ClassHelper {

    /**
     * 定义类集合 ( 用于存储所加载的类 )
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包下所有类
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有 Service 类
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clazz : CLASS_SET) {
            if (clazz.isAnnotationPresent(Service.class)) {
                classSet.add(clazz);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有 Controller 类
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clazz : CLASS_SET) {
            if (clazz.isAnnotationPresent(Controller.class)) {
                classSet.add(clazz);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有 Bean 类 ( 包括: Service, Controller 等 )
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }

    /**
     * 获取应用包名下某父类 ( 或接口 ) 的所有子类 ( 或实现类 )
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clazz: CLASS_SET) {
            if(superClass.isAssignableFrom(clazz)&&!superClass.equals(clazz)){
                classSet.add(clazz);
            }

        }
        return classSet;
    }

    /**
     * 获取应用包名下带有注解的所有类
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clazz: CLASS_SET) {
            if(clazz.isAnnotationPresent(annotationClass)){
                classSet.add(clazz);
            }

        }
        return classSet;
    }
}
