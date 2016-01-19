package cc.cafetime.common;

import cc.cafetime.common.annotation.Action;
import cc.cafetime.common.bean.Data;
import cc.cafetime.common.bean.Handler;
import cc.cafetime.common.bean.Param;
import cc.cafetime.common.bean.View;
import cc.cafetime.common.helper.*;
import cc.cafetime.common.util.CodecUtil;
import cc.cafetime.common.util.JsonUtil;
import cc.cafetime.common.util.ReflectionUtil;
import cc.cafetime.common.util.StreamUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求转发器
 * Created by liujing on 16/1/10.
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // 初始化相关的Helper类
        HelperLoader.init();
        // 获取 ServletContext 对象 ( 用于注册 Servlet )
        ServletContext servletContext = getServletConfig().getServletContext();
        // 注册处理 JSP 的 Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        // 注册处理静态资源的默认 Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");

        UploadHelper.init(servletContext);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletHelper.init(request, response);
        try {
            // 获取请求方法与请求路径
            String requestMethod = request.getMethod().toLowerCase();
            String requestPath = request.getPathInfo();

            if ("/favicon.ico".equals(requestPath)) {
                return;
            }
            if ("/".equals(requestPath) && StringUtils.isNotEmpty(ConfigHelper.getAppIndexPath())) {
                response.sendRedirect(request.getContextPath() + ConfigHelper.getAppIndexPath());
                return;
            }

            // 获取 Action
            Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
            if (handler != null) {
                // 获取 Controller 类及其 Bean 实例
                Class<?> controllerClass = handler.getControllerClass();
                Object controllerBean = BeanHelper.getBean(controllerClass);
                // 创建请求参数对象
                Param param;
                if (UploadHelper.isMultipart(request)) {
                    param = UploadHelper.createParam(request);
                } else {
                    param = RequestHelper.createParam(request);
                }
                // 调用 Action 方法
                Object result = null;
                Method actionMethod = handler.getActionMethod();
                if (param.isEmpty()) {
                    result = ReflectionUtil.invokeMethod(controllerBean, actionMethod);
                } else {
                    result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
                }
                // 处理 Action 方法的返回值
                if (result instanceof View) {
                    View view = (View) result;
                    view.setModule(handler.getModule());
                    handleViewResult(request, response, view);
                } else if (result instanceof Data) {
                    // 返回 JSON 数据
                    handleDataResult(response, (Data) result);
                }
            }
        } finally {
            ServletHelper.destory();
        }
    }

    private void handleDataResult(HttpServletResponse response, Data result) throws IOException {
        Data data = result;
        Object model = data.getModel();
        if (model != null) {
            response.setContentType("appliction/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            String json = JsonUtil.toJson(model);
            writer.write(json);
            writer.flush();
            writer.close();
        }
    }

    private void handleViewResult(HttpServletRequest request, HttpServletResponse response, View view) throws IOException, ServletException {
        String path = view.getPath();
        if (StringUtils.isNotEmpty(path)) {
            if (path.startsWith("/")) {
                response.sendRedirect(request.getContextPath() + path);
            } else {
                if (StringUtils.isNotEmpty(view.getModule())) {
                    path = view.getModule() + File.separator + path;
                }
                Map<String, Object> model = view.getModel();
                for (Map.Entry<String, Object> entry : model.entrySet()) {
                    request.setAttribute(entry.getKey(), entry.getValue());
                }
                request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request, response);
            }
        }
    }

}
