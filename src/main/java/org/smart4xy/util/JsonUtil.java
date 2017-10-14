package org.smart4xy.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Json工具类，处理json和pojo之间的转化，基于jackason
 * Created by issuser on 2017/10/14.
 */
public class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * pojo转化为json
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj){
        String json = null;
        try{
            json = OBJECT_MAPPER.writeValueAsString(obj);
        }catch (Exception e){
            LOGGER.error("to Json failure");
            throw new RuntimeException(e);
        }
        return json;
    }

    public static <T> T fromJson(String json,Class<T> type){
        T pojo = null;
        try{
            pojo = OBJECT_MAPPER.readValue(json,type);
        }catch (Exception e){
            LOGGER.error("to pojo failure");
            throw new RuntimeException(e);
        }
        return pojo;
    }
}
