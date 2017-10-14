package org.smart4xy.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 视图模型
 * Created by issuser on 2017/10/14.
 */
public class View {
    private String path;//视图路劲
    private Map<String,Object> model;//视图模型
    public View(String path){
        this.path = path;
        model = new HashMap<String, Object>();
    }

    public View addModel(String key,Object value){
        model.put(key,value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
