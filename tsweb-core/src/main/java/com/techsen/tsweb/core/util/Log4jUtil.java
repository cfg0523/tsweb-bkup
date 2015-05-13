package com.techsen.tsweb.core.util;

import org.apache.log4j.Logger;

/**
 * log4j日志工具类
 */
public class Log4jUtil {

    /**
     * 根据对象实例获取Logger
     */
    public static Logger getLogger(Object obj) {
        return Logger.getLogger(obj.getClass());
    }

    /**
     * 根据Class对象获取Logger
     */
    public static <T> Logger getLogger(Class<T> clazz) {
        return Logger.getLogger(clazz);
    }
}