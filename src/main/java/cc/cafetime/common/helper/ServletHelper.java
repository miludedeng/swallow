package cc.cafetime.common.helper;

import cc.cafetime.common.util.LoggerUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet 助手类
 * Created by liujing on 16/1/19.
 */
public class ServletHelper {

    /**
     * 使每个线程独自拥有一份 ServletHelper 实例
     */
    private static final ThreadLocal<ServletHelper> SERVLET_HELPER_HOLER = new ThreadLocal<ServletHelper>();

    private HttpServletRequest request;
    private HttpServletResponse response;

    private ServletHelper(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
    }

    /**
     * 初始化
     */
    public static void init (HttpServletRequest request, HttpServletResponse response){
        SERVLET_HELPER_HOLER.set(new ServletHelper(request,response));
    }

    /**
     * 销毁
     */
    public static void destory(){
        SERVLET_HELPER_HOLER.remove();
    }

    /**
     * 将属性值放入 Request 中
     */
    public static void setRequestAttribute(String key, Object value){
        getRequest().setAttribute(key,value);
    }

    /**
     * 从 Request 中获取属性
     */
    public static <T> T getRequestAttribute(String key){
        return (T) getRequest().getAttribute(key);
    }

    /**
     * 从 Request 中移除属性
     */
    public static void removeRequestAttribute(String key){
        getRequest().removeAttribute(key);
    }

    /**
     * 发送重定向
     */
    public static void sendRedirect(String location){
        try {
            getResponse().sendRedirect(getRequest().getContextPath() + location);
        }catch (IOException e){
            LoggerUtil.logger().error("redirect failure",e);
        }
    }

    /**
     * 将属性放入 Session 中
     */
    public static void setSessionAttribute(String key, Object value){
        getSession().setAttribute(key, value);
    }

    /**
     * 从 Session 中获取属性
     */
    public static <T> T getSessionAttribute(String key){
        return (T) getRequest().getSession().getAttribute(key);
    }

    /**
     * 使 Session 失效
     */
    public static void invalidateSession(){
        getRequest().getSession().invalidate();
    }

    /**
     * 获取 Request 对象
     */
    private static HttpServletRequest getRequest(){
        return SERVLET_HELPER_HOLER.get().request;
    }

    /**
     * 获取 Response 对象
     */
    private static HttpServletResponse getResponse(){
        return SERVLET_HELPER_HOLER.get().response;
    }

    /**
     * 获取 Session 对象
     */
    private static HttpSession getSession(){
        return getRequest().getSession();
    }

    /**
     * 获取 ServletContext 对象
     */
    private static ServletContext getServletContext(){
        return getRequest().getServletContext();
    }

}
