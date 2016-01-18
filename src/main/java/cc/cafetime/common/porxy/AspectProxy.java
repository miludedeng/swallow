package cc.cafetime.common.porxy;

import cc.cafetime.common.util.LoggerUtil;
import org.apache.log4j.PatternLayout;

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

        try{
            if(intercept(clazz, method, params)){
                before(clazz, method,params);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch(Exception e){
            LoggerUtil.logger().error("proxy failure",e);
            error(clazz,method, params,e);
            throw e;
        } finally{
            end();
        }

        return null;
    }

    protected void end(){}

    protected  void error(Class<?> clazz, Method method, Object[] params, Exception e){ }

    private void before(Class<?> clazz, Method method, Object[] params) { }

    private boolean intercept(Class<?> clazz, Method method, Object[] params) {
        return true;
    }

    private void begin() { }
}
