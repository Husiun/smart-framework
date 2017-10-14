package org.smart4xy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流操作工具类
 * Created by issuser on 2017/10/14.
 */
public class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 从输入流中获取字符串
     * @return
     */
    public static String getString(InputStream is){
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(is));//输入流利用缓存流
            String line;
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line);
            }
        }catch (Exception e){
            LOGGER.error("read is failure");
            throw new RuntimeException(e);
        }finally {
            try {
                reader.close();//关闭流操作
            }catch (Exception e){
                LOGGER.error("close is failure",e);
            }
        }
        return stringBuilder.toString();
    }
}
