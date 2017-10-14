package org.smart4xy.helper;

import javafx.scene.effect.Reflection;
import org.apache.commons.lang3.StringUtils;
import org.smart4xy.annotation.Inject;
import org.smart4xy.util.ArrayUtil;
import org.smart4xy.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 实现依赖注入类,带有inject注解的进行实例化
 * Created by issuser on 2017/10/14.
 */
public final class IocHelper {
    static{
        //获取bean类和对应实例的map集合
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(!beanMap.isEmpty()){
            //遍历map，取出对应的类和实例
            for(Map.Entry<Class<?>,Object> entryMap:beanMap.entrySet()){
                Class<?> beanClass = entryMap.getKey();//bean类
                Object instance = entryMap.getValue();//对应的实例
                Field[] fields = beanClass.getDeclaredFields();//获取bean类所有的成员变量
                if(ArrayUtil.isNotEmpty(fields)){
                    for(Field field:fields){
                        if(field.isAnnotationPresent(Inject.class)){
                            Class<?> beanfieldClass = field.getType();//获取该类类名
                            //从beanMap中获取类对应的实例
                            Object beanInstance = beanMap.get(beanfieldClass);
                            if(beanfieldClass != null){
                                ReflectionUtil.setField(instance,field,beanInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
