package org.smart4xy.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 *
 * 数组辅助工具类
 * Created by issuser on 2017/10/14.
 */
public final class ArrayUtil {

    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }

    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }

    //测试
    public static void main(String[] args) {
        String[] strs = {"22","33"};
        System.out.println("result = "+isNotEmpty(strs));
    }
}
