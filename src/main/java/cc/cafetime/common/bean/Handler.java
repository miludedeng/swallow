package cc.cafetime.common.bean;

import java.lang.reflect.Method;

/**
 * 封装 Action 信息
 * Created by liujing on 16/1/10.
 */
public class Handler {

    /**
     * Controller 类
     */
    private Class<?> controllerClass;

    /**
     * Action 方法
     */
    private Method actionMethod;

    /**
     * 模块名称
     */
    private String module;

    public Handler(Class<?> controllerClass, Method actionMethod, String module) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
        this.module = module;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public String getModule() {
        return module;
    }
}
