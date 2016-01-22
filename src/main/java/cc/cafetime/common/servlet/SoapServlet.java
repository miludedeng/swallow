package cc.cafetime.common.servlet;

import cc.cafetime.common.ConfigConstant;
import cc.cafetime.common.annotation.Soap;
import cc.cafetime.common.helper.BeanHelper;
import cc.cafetime.common.helper.ClassHelper;
import cc.cafetime.common.helper.SoapHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import java.util.Set;

/**
 * SOAP Servlet
 * Created by liujing on 16/1/22.
 */
@WebServlet(urlPatterns = ConfigConstant.SOAP_SERVLET_URL, loadOnStartup = 0)
public class SoapServlet extends CXFNonSpringServlet {

    @Override
    protected void loadBus(ServletConfig sc) {
        // 初始化 CXF 总线
        super.loadBus(sc);
        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        // 发布 SOAP 服务
        publishSoapService();
    }

    private void publishSoapService() {
        // 遍历所有标注了 SOAP 注解的类
        Set<Class<?>> soapClassSet = ClassHelper.getClassSetByAnnotation(Soap.class);
        if (CollectionUtils.isNotEmpty(soapClassSet)){
            for (Class<?> soapClass : soapClassSet){
                // 获取 SOAP 地址
                String address = getAddress(soapClass);
                // 获取 SOAP 类的接口
                Class<?> soapInterfaceClass = getSoapInterfaceClass(soapClass);
                // 获取 SOAP 类的实例
                Object soapInstance = BeanHelper.getBean(soapClass);
                // 发布 SOAP 服务
                SoapHelper.publishService(address,soapInterfaceClass,soapInstance);
            }
        }
    }

    private String getAddress(Class<?> soapClass) {
        String address;
        // 若 SOAP 注解的 value 属性不为空, 则获取当前值, 否则获取类名
        String soapValue = soapClass.getAnnotation(Soap.class).value();
        if(StringUtils.isNotEmpty(soapValue)){
            address = soapValue;
        }else{
            address = getSoapInterfaceClass(soapClass).getSimpleName();
        }
        // 确保最前面只有一个
        if(!address.startsWith("/")){
            address = "/" + address;
        }
        address = address.replaceAll("\\/+","/");
        return address;
    }

    private Class<?> getSoapInterfaceClass(Class<?> soapClass) {
        // 获取 SOAP 实现类的第一个接口作为 SOAP 服务接口
        return soapClass.getInterfaces()[0];
    }

}
