package org.smart4xy.helper;

import org.smart4xy.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * bean助手类,
 * 用于将ClassHelper类获得的bean类，和reflection获取的实例存入静态的map中
 * 此时该map相当于bean容器，随时获取bean容器
 * 及对应的实例
 * Created by issuser on 2017/10/14.
 */
public final class BeanHelper {
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>, Object>();
    static{
        Set<Class<?>> classSet = ClassHelper.getBeanClassSet();
        for(Class cla:classSet){
            Object obj = ReflectionUtil.newInstance(cla);
            BEAN_MAP.put(cla,obj);
        }
    }

    /**
     * 获取bean容器
     * @return
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cla){
        if(!BEAN_MAP.containsKey(cla)){
            throw new RuntimeException("can not get such class" + cla);
        }
        return (T)BEAN_MAP.get(cla);
    }
}
