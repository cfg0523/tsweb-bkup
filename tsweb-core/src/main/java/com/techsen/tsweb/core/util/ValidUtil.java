package com.techsen.tsweb.core.util;

import static com.techsen.tsweb.core.util.Const.EMPTY_STRING;
import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;

import java.util.Collection;
import java.util.Map;

/**
 * 判断有效性的工具
 */
public class ValidUtil {
    
    /**
     * 判断对象为Null
     */
    public static <T> boolean isNull(T obj) {
        return obj == null;
    }
    
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || EMPTY_STRING.equals(str);
    }
    
    /**
     * 判断字符串的有效性
     */
    public static boolean isValid(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断数组是否为空
     */
    public static <T> boolean isEmpty(T[] arr) {
        return isNull(arr) || arr.length == 0;
    }
    
    /**
     * 判断数组的有效性
     */
    public static <T> boolean isValid(T[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 判断集合是否为空
     */
    public static <E> boolean isEmpty(Collection<E> coll) {
        return isNull(coll) || coll.isEmpty();
    }
    
    /**
     * 判断集合的有效性
     */
    public static <E> boolean isValid(Collection<E> coll) {
        return !isEmpty(coll);
    }

    /**
     * 判断Map是否为空
     */
    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return isNull(map) || map.isEmpty();
    }
    
    /**
     * 判断Map的有效性
     */
    public static <K, V> boolean isValid(Map<K, V> map) {
        return !isEmpty(map);
    }
    
    /**
     * 判断对象不为空<br/>
     * @throws 
     */
    public static boolean assertNotNull(Object obj) {
        if (obj == null) {
            throwRuntimeException("空对象异常");
        }
        return true;
    }
}