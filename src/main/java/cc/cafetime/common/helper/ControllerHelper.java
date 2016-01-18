package cc.cafetime.common.helper;

import cc.cafetime.common.annotation.Action;
import cc.cafetime.common.bean.Handler;
import cc.cafetime.common.bean.Request;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Controller 助手类
 * Created by liujing on 16/1/10.
 */
public final class ControllerHelper {

    /**
     * 用于处理存放请求与处理器的映射关系 ( 简称 Action Map )
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取所有的Controller类
        Set<Class<?>>  controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollectionUtils.isNotEmpty(controllerClassSet)){
            // 遍历这些 Controller 类
            for (Class<?> controllerClass : controllerClassSet){
                // 获取 Controller 类中定义的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtils.isNotEmpty(methods)){
                    // 遍历这些 Controller 类中得方法
                    for (Method method : methods){
                        //判断当前方法是否带有Action注解
                        if (method.isAnnotationPresent(Action.class)){
                            // 从 Action 注解中获取 URL 映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();

                            //验证映射规则
                            if(mapping.matches(("\\w+:/\\w*"))){
                                String [] array = mapping.split(":");
                                if(ArrayUtils.isNotEmpty(array) && array.length==2){
                                    // 获取请求方法与请求路径
                                    String requestMehod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMehod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    //初始化 Action Map
                                    ACTION_MAP.put(request, handler);
                                }

                            }

                        }
                    }
                }
            }

        }
    }

    /**
     * 获取 Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath){
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }

}
