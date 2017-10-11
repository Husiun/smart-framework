package org.smart4xy.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * Created by xy on 2017/10/11.
 */
public class PropsUtil {

    /**
     * 加载配置文件
     * @param filePath
     * @return
     */
    public static Properties loadProperty(String filePath){
        Properties prop = null;
        InputStream is = null;
        try{
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
            if(is == null){
                throw new FileNotFoundException("file not found");
            }
            prop = new Properties();
            prop.load(is);
        }catch(Exception e){
            //logger.error("load file is wrong",e);
        }finally{
            if(is != null){
                try{
                    is.close();
                }catch (Exception e){
                    //logger.error("close stream is failure");
                }

            }
        }
        return prop;
    }
    /**
     * 获取字符行数据，不可以指定默认类型
     * @param prop
     * @param key
     * @return
     */
    public static String getString(Properties prop, String key){
        return getString(prop,key,"");
    }
    /**
     * 获取字符型数据
     * @param prop
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties prop,String key,String defaultValue){

        String value = defaultValue;
        if(prop.containsKey(key)){
            value = prop.getProperty(key);
        }
        return value;
    }

    /**
     * 获取int型属性，默认值为0
     * @param prop
     * @param key
     * @return
     */
    public static int getInt(Properties prop,String key){
        return getInt(prop,key,0);
    }


    public static int getInt(Properties prop,String key,int defaultValue){
        int value = defaultValue;
        if(prop.containsKey(key)){
            value =CastUtil.castInt(prop.getProperty(key));
        }
        return value;
    }

    /**
     * 获取boolean型属性，默认值false
     * @param prop
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties prop,String key){
        return getBoolean(prop,key,false);
    }

    public static boolean getBoolean(Properties prop,String key,boolean defaultValue){
        boolean value = defaultValue;
        if(prop.containsKey(key)){
            value = CastUtil.castBoolean(prop.getProperty(key));
        }
        return value;
    }
}
