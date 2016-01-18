package cc.cafetime.common.porxy;

/**
 * 代理接口
 * Created by liujing on 16/1/12.
 */
public interface Proxy {
    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
