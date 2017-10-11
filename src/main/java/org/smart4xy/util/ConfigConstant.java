package org.smart4xy.util;

/**
 * 提供相关配置的常量
 * Created by xy on 2017/10/11.
 */
public interface ConfigConstant {

    String CONFIG_FILE = "smart.properties";
    //数据库连接相关
    String JDBC_DRIVER = "smart.framework.jdbc.driver";
    String JDBC_URL = "smart.framework.jdbc.url";
    String JDBC_USERNAME = "smart.framework.jdbc.username";
    String JDBC_PASSWORD = "smart.framework.jdbc.password";

    String APP_BASE_PACKAGE = "smart.framework.app.base_package";//包的基本路劲
    String APP_JSP_PATH = "smart.framework.app.jsp_path";//jsp资源的路劲
    String APP_ASSET_PATH = "smart.framework.app.asset_path";//静态资源的基本路劲
}
