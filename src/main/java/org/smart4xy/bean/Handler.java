package org.smart4xy.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.lang.reflect.Method;

/**
 * 封装Action信息
 * 把controller类和对应的action方法封装到一起
 * Created by issuser on 2017/10/14.
 */
public class Handler {

    private Class<?> controllerClass;//controller类
    private Method actionMethod;//action方法
    public Handler(Class<?> controllerClass,Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }
    //getter and setter


    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public void setActionMethod(Method actionMethod) {
        this.actionMethod = actionMethod;
    }

}
