package cc.cafetime.common.helper;

import cc.cafetime.common.ConfigConstant;
import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * SOAP 助手类
 * Created by liujing on 16/1/22.
 */
public final class SoapHelper {

    private static final List<Interceptor<? extends Message>> inInterceptorList = new ArrayList<Interceptor<? extends Message>>();
    private static final List<Interceptor<? extends Message>> outInterceptorList = new ArrayList<Interceptor<? extends Message>>();

    static {
        // 添加 Logging Interceptor
        if (ConfigHelper.getBoolean(ConfigConstant.SOAP_LOG)){
            LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
            inInterceptorList.add(loggingInInterceptor);
            LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
            outInterceptorList.add(loggingOutInterceptor);
        }
    }

    /**
     * 发布 SOAP 服务
     */
    public static void publishService(String wsdl, Class<?> interfaceClass, Object implementInstance){
        ServerFactoryBean factory = new ServerFactoryBean();
        factory.setAddress(wsdl);
        factory.setServiceClass(interfaceClass);
        factory.setServiceBean(implementInstance);
        factory.setInInterceptors(inInterceptorList);
        factory.setOutInterceptors(outInterceptorList);
    }

    /**
     * 创建 SOAP 客户端
     */
    public static <T> T createClient(String wsdl, Class<? extends T> interfaceClass){
        ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
        factory.setServiceClass(interfaceClass);
        factory.setInInterceptors(inInterceptorList);
        factory.setOutInterceptors(outInterceptorList);
        return factory.create(interfaceClass);
    }
}
