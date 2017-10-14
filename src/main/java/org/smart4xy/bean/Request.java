package org.smart4xy.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 封装请求方法和请求路劲
 * Created by issuser on 2017/10/14.
 */
public class Request {
    //请求方法
    private String requestMethod;
    //请求路劲
    private String requestPath;

    public Request(String requestMethod,String requestPath){
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }
    //getter setter

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this,obj);
    }
}
