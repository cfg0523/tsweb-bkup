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
     * 判断字符串的有效性
     */
    public static boolean isValid(String str) {
        return str != null && !EMPTY_STRING.equals(str.trim());
    }

    /**
     * 判断数组的有效性
     */
    public static <T> boolean isValid(T[] arr) {
        return arr != null && arr.length > 0;
    }

    /**
     * 判断集合的有效性
     */
    public static <E> boolean isValid(Collection<E> coll) {
        return coll != null && !coll.isEmpty();
    }

    /**
     * 判断Map的有效性
     */
    public static <K, V> boolean isValid(Map<K, V> map) {
        return map != null && !map.isEmpty();
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