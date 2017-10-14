package org.smart4xy;

import org.smart4xy.helper.BeanHelper;
import org.smart4xy.helper.ClassHelper;
import org.smart4xy.helper.ControllerHelper;
import org.smart4xy.helper.IocHelper;
import org.smart4xy.util.ClassUtil;

/**
 * 集中加载所有的helper类(除了configHelper)，实际上就是加载他们的静态代码块
 * Created by issuser on 2017/10/14.
 */
public final class HelperLoader {

    public static void init(){
        Class<?>[] classes = {
                BeanHelper.class, ClassHelper.class,
                ControllerHelper.class, IocHelper.class
        };
        for(Class<?> cla:classes){
            ClassUtil.classLoad(cla.getName(),true);//加载类
        }
    }
}
