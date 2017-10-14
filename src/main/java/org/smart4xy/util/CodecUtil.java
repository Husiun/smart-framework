package org.smart4xy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * url编码与解码操作工具类
 * Created by issuser on 2017/10/14.
 */
public class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);


    public static String encodeURL(String url){
        String urlStr = "";
        try{
            urlStr = URLEncoder.encode(url,"UTF-8");
        }catch (Exception e){
            LOGGER.error("encode is failure");
            throw new RuntimeException(e);
        }
        return urlStr;
    }

    public static String decodeURL(String url){
        String decStr = "";
        try{
            decStr = URLDecoder.decode(url,"UTF-8");
        }catch (Exception e){
            LOGGER.error("decode is failure");
            throw new RuntimeException(e);
        }
        return decStr;
    }

    //测试
    public static void main(String[] args) {
        System.out.println("编码:"+decodeURL("%E6%96%87%E6%A1%A3"));
    }

}
