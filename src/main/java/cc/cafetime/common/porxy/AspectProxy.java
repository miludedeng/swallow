package cc.cafetime.common.porxy;

import cc.cafetime.common.util.LoggerUtil;

import java.lang.reflect.Method;

/**
 * 切面代理
 * Created by liujing on 16/1/12.
 */
public abstract class AspectProxy implements Proxy {

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;

        Class<?> clazz = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();

        try {
            if (intercept(clazz, method, params)) {
                before(clazz, method, params);
                result = proxyChain.doProxyChain();
                after(clazz, method, params,result);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            LoggerUtil.logger().error("proxy failure", e);
            error(clazz, method, params, e);
            throw e;
        } finally {
            end();
        }

        return result;
    }

    public void begin() {
    }

    public boolean intercept(Class<?> clazz, Method method, Object[] params) throws Throwable {
        return true;
    }

    public void before(Class<?> clazz, Method method, Object[] params) throws Throwable {
    }

    public void after(Class<?> clazz, Method method, Object[] params, Object result) throws Throwable {
    }

    public void error(Class<?> clazz, Method method, Object[] params, Throwable e) throws Throwable {
    }

    public void end() throws Throwable {
    }

}
