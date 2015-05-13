package com.techsen.tsweb.core.util;

import static com.techsen.tsweb.core.util.CloseUtil.close;
import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;
import static com.techsen.tsweb.core.util.Log4jUtil.getLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 读取tsweb.properties配置工具类
 */
public class AppConfig {
    private static Logger logger = getLogger(AppConfig.class);

    private static Properties props = new Properties();
    private static String PROPERTIES_FILENAME = "META-INF/system.properties";

    /**
     * 用来在运行时判断是否重新加载tsweb.properties中的配置
     */
    private static boolean reload = false;

    /**
     * 上一次加载tsweb.properties时的文件的修改时间
     */
    private static long lastModified = -1L;

    static {
        loadConfig();
        reload = "true".equals(props.getProperty("reload"));
        if (reload) {
            logger.info("dynamic load " + PROPERTIES_FILENAME + ": " + reload);
        }
    }

    /**
     * 加载tsweb.properties中的配置
     */
    private static void loadConfig() {
        InputStream inputStream = null;
        URL url = AppConfig.class.getClassLoader().getResource(
                PROPERTIES_FILENAME);
        if (url == null) {
            logger.fatal("FileNotFoundException: " + PROPERTIES_FILENAME);
            throwRuntimeException("FileNotFoundException: "
                    + PROPERTIES_FILENAME);
        }
        try {
            String filepath = URLDecoder.decode(url.getFile(), "UTF-8");
            File file = new File(filepath);
            inputStream = new FileInputStream(file);
            if (file.lastModified() > lastModified) {
                props.load(inputStream);
                lastModified = file.lastModified();
                logger.info("load [" + PROPERTIES_FILENAME + "] success");
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException: UTF-8");
            throwRuntimeException(e);
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException: " + PROPERTIES_FILENAME);
            throwRuntimeException(e);
        } catch (IOException e) {
            logger.error("IOException: " + PROPERTIES_FILENAME);
            throwRuntimeException(e);
        } finally {
            close(inputStream);
        }
    }

    /**
     * 获取属性值
     */
    public static String getProperty(String key) {
        if (reload) {
            loadConfig();
        }
        props.setProperty("reload", String.valueOf(reload));
        return props.getProperty(key);
    }

    /**
     * 获取Integer值
     */
    public static Integer getInteger(String key) {
        return Integer.valueOf(getProperty(key));
    }

    /**
     * 获取Double值
     */
    public static Double getDouble(String key) {
        return Double.valueOf(getProperty(key));
    }

    /**
     * 获取Boolean值
     */
    public static Boolean getBoolean(String key) {
        return Boolean.valueOf(getProperty(key));
    }

    /**
     * 用来在运行时改变系统是否启用动态加载tsweb.properties功能
     */
    public static void setReaload(boolean reload) {
        AppConfig.reload = reload;
        logger.info("dynamic load " + PROPERTIES_FILENAME + ": " + reload);
    }

}