package org.smart4xy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过classHelper获取了所有的类，但是需要实例化，本类用于包装反射基本类型
 * Created by issuser on 2017/10/14.
 */
public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 实例对象
     * @param cla
     * @return
     */
    public static Object newInstance(Class<?> cla){
        Object instance = null;
        try{
            instance =cla.newInstance();
        }catch (Exception e){
            LOGGER.error("new instance failure");
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     * @param obj
     * @param method
     * @param args
     * @return
     */
    public static Object invokeMethod(Object obj, Method method,Object...args){
        Object object = null;
        try{
            method.setAccessible(true);
            object = method.invoke(obj,args);
        }catch (Exception e){
            LOGGER.error("invoke method failure");
            throw new RuntimeException(e);
        }
        return object;
    }

    /**
     * 设置成员变量的值
     * @param obj
     * @param field
     * @param value
     */
    public static void setField(Object obj, Field field,Object value){
        try{
            field.setAccessible(true);
            field.set(obj,value);
        }catch (Exception e){
            LOGGER.error("set field failure");
            throw new RuntimeException(e);
        }
    }
}
