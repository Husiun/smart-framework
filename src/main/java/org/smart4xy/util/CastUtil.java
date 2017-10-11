package org.smart4xy.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by xy on 2017/10/11.
 */
public class CastUtil {

    /**
     * 转为String
     * @param obj
     * @return
     */
    public static String castString(Object obj){
        return castString(obj,"");
    }

    public static String castString(Object obj,String defaultValue){
        return obj != null ? String.valueOf(obj):defaultValue;
    }

    /**
     * 转为int
     * @param obj
     * @return
     */
    public static int castInt(Object obj){
        return castInt(obj,0);
    }

    @SuppressWarnings("unchecked")
    public static int castInt(Object obj,int defaultValue){
        int value = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try{
                    value = Integer.parseInt(strValue);
                }catch(Exception e){
                    e.printStackTrace();
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
     * 转为boolean
     * @param obj
     * @return
     */
    public static boolean castBoolean(Object obj){
        return castBoolean(obj,false);
    }

    public static boolean castBoolean(Object obj,boolean defaultValue){
        boolean value = defaultValue;
        if(obj != null){
            value = Boolean.parseBoolean(castString(obj));
        }
        return value;
    }
}
