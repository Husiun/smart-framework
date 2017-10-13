package org.smart4xy.helper;

import org.smart4xy.annotation.Controller;
import org.smart4xy.annotation.Service;
import org.smart4xy.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 类加载助手类
 * Created by issuser on 2017/10/14.
 */
public final class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;
    static{
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
     * 获取基础包下面带有Controller注解的类
     * @return
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class cla:classSet) {
            if(cla.isAnnotationPresent(Controller.class)){
                classSet.add(cla);
            }
        }

        return classSet;
    }

    /**
     * 获取基础包下面带有Service注解的类
     * @return
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class cla:classSet) {
            if(cla.isAnnotationPresent(Service.class)){
                classSet.add(cla);
            }
        }

        return classSet;
    }

    /**
     * 将得到的这些类当作bean
     * @return
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        classSet.addAll(getServiceClassSet());
        classSet.addAll(getControllerClassSet());
        return classSet;
    }
}
