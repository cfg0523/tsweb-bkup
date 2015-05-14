package com.techsen.tsweb.core.util;

import static com.techsen.tsweb.core.util.Const.UTF8;
import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 字符编码解码工具
 */
public class CharCodeUtil {
    
    /**
     * 以默认的UTF-8编码字符串
     */
    public static String encode(String str) {
        String result = str;
        try {
            result = URLEncoder.encode(str, UTF8);
        } catch (UnsupportedEncodingException e) {
            throwRuntimeException(e);
        }
        return result;
    }
    
    /**
     * 以默认的UTF-8解码字符串
     */
    public static String decode(String str) {
        String result = str;
        try {
            result = URLDecoder.decode(str, UTF8);
        } catch (UnsupportedEncodingException e) {
            throwRuntimeException(e);
        }
        return result;
    }
}
