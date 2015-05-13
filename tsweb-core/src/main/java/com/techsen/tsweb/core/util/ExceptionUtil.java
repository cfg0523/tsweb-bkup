package com.techsen.tsweb.core.util;

/**
 * 异常工具类
 */
public class ExceptionUtil {
    /**
     * 抛出RuntimeException
     */
    public static void throwRuntimeException(Exception e)
            throws RuntimeException {
        if (e instanceof RuntimeException) {
            throw (RuntimeException) e;
        } else {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 以给定的消息抛出一个RuntimeException
     */
    public static void throwRuntimeException(String msg)
            throws RuntimeException {
        throw new RuntimeException(msg);
    }
}
