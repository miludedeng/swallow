package cc.cafetime.common.porxy;

import cc.cafetime.common.annotation.Transaction;
import cc.cafetime.common.helper.DatabaseHelper;
import cc.cafetime.common.util.LoggerUtil;

import java.lang.reflect.Method;

/**
 * 事务代理
 * Created by liujing on 16/1/17.
 */
public class TransactionProxy implements Proxy {

    private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        boolean flag = FLAG_HOLDER.get();
        Method method = proxyChain.getTargetMethod();
        if (!flag && method.isAnnotationPresent(Transaction.class)) {
            FLAG_HOLDER.set(true);
            try {
                DatabaseHelper.beginTransaction();
                LoggerUtil.logger().debug("begin transaction");
                result = proxyChain.doProxyChain();
                DatabaseHelper.commitTransaction();
                LoggerUtil.logger().debug("commit transaction");
            } catch (Exception e) {
                DatabaseHelper.rollbackTransaction();
                LoggerUtil.logger().debug("rollback transaction");
            } finally {
                FLAG_HOLDER.remove();
            }
        } else {
            result = proxyChain.doProxyChain();
        }
        return result;
    }
}
