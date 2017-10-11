package org.smart4xy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * 类操作基础工具
 * 加载基础包下面所有的类
 * Created by xy on 2017/10/11.
 */
public final class ClassUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    //获取类加载器
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    //加载类
    public static Class<?> classLoad(String className,boolean isInitialize){
        Class<?> cla = null;
        try{
            cla.forName(className,isInitialize,getClassLoader());
        }catch (Exception e){
            LOGGER.error("load class is failure",e);
            throw new RuntimeException(e);
        }
        return cla;
    }

    //加载指定包名下的所有类
    public static Set<Class<?>> getClassSet(String packageName){

        return null;
    }





    //测试
    public static void main(String[] args) {
        Class<?> cla = classLoad("org.smart4xy.util.CastUtil",false);
        System.out.println("cla = "+cla);
    }
}
