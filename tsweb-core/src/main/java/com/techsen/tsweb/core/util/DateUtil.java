package com.techsen.tsweb.core.util;

import static com.techsen.tsweb.core.util.Const.FORMAT_DEFAULT_DATE;
import static com.techsen.tsweb.core.util.Const.FORMAT_DEFAULT_TIME;
import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 日期时间工具
 */
public class DateUtil {
    private static Logger logger = Log4jUtil.getLogger(DateUtil.class);

    public static final SimpleDateFormat SIMPLEDATEFORMAT_DEFAULT_DATE = new SimpleDateFormat(
            FORMAT_DEFAULT_DATE);
    public static final SimpleDateFormat SIMPLEDATEFORMAT_DEFAULT_TIME = new SimpleDateFormat(
            FORMAT_DEFAULT_TIME);

    /**
     * 以给定的格式格式化日期或时间
     */
    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 以默认格式yyyy-MM-dd格式化日期
     */
    public static String formatDate(Date date) {
        return SIMPLEDATEFORMAT_DEFAULT_DATE.format(date);
    }

    /**
     * 以默认格式HH:mm:ss格式化时间
     */
    public static String formatTime(Date time) {
        return SIMPLEDATEFORMAT_DEFAULT_TIME.format(time);
    }

    /**
     * 以给定的格式将一个字符串解析为Date
     */
    public static Date parse(String dateStr, String format) {
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            result = sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("ParseException: dateStr=" + dateStr + " & format="
                    + format);
            throwRuntimeException(e);
        }
        return result;
    }

    /**
     * 以默认格式yyyy-MM-dd将一个字符串解析为Date
     */
    public static Date parseDate(String dateStr, String format) {
        Date result = null;
        try {
            result = SIMPLEDATEFORMAT_DEFAULT_DATE.parse(dateStr);
        } catch (ParseException e) {
            logger.error("ParseException: dateStr=" + dateStr + " & format="
                    + format);
            throwRuntimeException(e);
        }
        return result;
    }

    /**
     * 以默认格式HH:mm:ss将一个字符串解析为Date
     */
    public static Date parseTime(String timeStr, String format) {
        Date result = null;
        try {
            result = SIMPLEDATEFORMAT_DEFAULT_DATE.parse(timeStr);
        } catch (ParseException e) {
            logger.error("ParseException: timeStr=" + timeStr + " & format="
                    + format);
            throwRuntimeException(e);
        }
        return result;
    }
}
