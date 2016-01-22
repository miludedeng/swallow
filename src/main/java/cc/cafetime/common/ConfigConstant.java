package cc.cafetime.common;

/**
 * Created by liujing on 16/1/9.
 */
public interface ConfigConstant {

    String CONFIG_FILE = "config.properties";
    String JDBC_DRIVER = "jdbc.driver";
    String JDBC_URL = "jdbc.url";
    String JDBC_USERNAME = "jdbc.username";
    String JDBC_PASSWORD = "jdbc.password";

    String APP_BASE_PACKAGE = "framework.app.base_package";
    String APP_JSP_PATH = "framework.app.jsp_path";
    String APP_ASSET_PATH = "framework.app.asset_path";
    String APP_UPLOAD_LIMIT = "framework.app.upload_limit";
    String APP_INDEX_PATH = "framework.app.index_path";

    String SOAP_SERVLET_URL="/soap/*";
    String SOAP_LOG = "soap.log";


    String REST_LOG = "rest.log";
    String REST_IS_JSONP = "rest.jsonp";
    String REST_JSONP_FUNCTION = "rest.jsonp.function";
    String REST_IS_CORS = "rest.cors";
    String REST_CORS_ORIGIN = "rest.cors.origin";
    String REST_SERVLET_URL = "/rest/*";
}
