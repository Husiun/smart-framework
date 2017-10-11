package org.smart4xy.helper;

import org.smart4xy.util.ConfigConstant;
import org.smart4xy.util.PropsUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 * Created by xy on 2017/10/11.
 */
public final class ConfigHelper {

    //文件加载
    private static final Properties CONFIG_PROPS = PropsUtil.loadProperty(ConfigConstant.CONFIG_FILE);

    //获取jdbcdriver
    public static String getJDBCDriver(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    //获取jdbcurl
    public static String getJDBCURL(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

    //获取jdbc username
    public static String getJDBCUsername(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    //获取jdbc password
    public static String getJDBCPassword(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }

    //获取基础包路劲
    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }

    //获取jsp路劲
    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH);
    }


    //获取静态资源路劲
    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH);
    }
}
