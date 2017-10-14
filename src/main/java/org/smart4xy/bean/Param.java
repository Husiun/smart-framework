package org.smart4xy.bean;

import org.smart4xy.util.CastUtil;

import java.util.Map;

/**
 * 请求参数对象
 * Created by issuser on 2017/10/14.
 */
public class Param {
    private Map<String,Object> paramMap;
    public Param(Map<String,Object> paramMap){
        this.paramMap = paramMap;
    }

    /**
     * 根据参数获取long型数值
     * @param name
     * @return
     */
    public long getLong(String name){
        return CastUtil.castLong(name);
    }

    /**
     * 获取所有字段信息
     * @return
     */
    public Map<String,Object> getMap(){
        return paramMap;
    }
}
