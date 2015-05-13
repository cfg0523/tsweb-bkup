package com.techsen.tsweb.core.util;

import static com.techsen.tsweb.core.util.Const.EMPTY_STRING;

import java.util.UUID;

/**
 * UUID工具类
 */
public class UUIDUtil {
    /**
     * 生成32位字符的uuid
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", EMPTY_STRING);
    }
}
