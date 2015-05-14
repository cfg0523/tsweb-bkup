package com.techsen.tsweb.core.util;

import static com.techsen.tsweb.core.util.CharCodeUtil.decode;
import static com.techsen.tsweb.core.util.CloseUtil.close;
import static com.techsen.tsweb.core.util.Const.EMPTY_STRING;
import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;
import static com.techsen.tsweb.core.util.Log4jUtil.getLogger;
import static com.techsen.tsweb.core.util.PropertiesUtil.loadProperties;
import static com.techsen.tsweb.core.util.PropertiesUtil.mergeProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 读取所有配置文件的工具类
 * 读取的文件包括如下：
 * classpath:META-INF/system.properties
 * classpath:META-INF/**\/${project.name}-*.properties
 */
public class AppConfig {
    private static Logger logger = getLogger(AppConfig.class);

    private static Properties props = new Properties();
    private static String SYSTEM_PROPERTIES_PATH = "META-INF/system.properties";

    /**
     * 用来在运行时判断是否重新加载system.properties中的配置
     */
    private static boolean reload = false;

    /**
     * 项目的工程名， 系统检测classpath:META-INF/system.properties中的project.name属性，
     * 将会根据检测到的值匹配以下路径规则的properties文件：
     * classpath:META-INF/**\/${project.name}-*.properties
     */
    private static String PROJECT_NAME = EMPTY_STRING;

    /**
     * 上一次加载system.properties时的文件的修改时间
     */
    private static long lastModified = -1L;

    /**
     * 暂存classpath:META-INF/**\/${project.name}-*.properties文件的lastModified
     */
    private static Map<String, Long> lastModifiedProperties = new HashMap<String, Long>();

    static {
        // 第一次加载时设置reload的值
        loadConfig();

        // 第一次加载时设置reload的值
        reload = "true".equals(props.getProperty("reload"));
        if (reload) {
            logger.info("dynamic load " + SYSTEM_PROPERTIES_PATH + ": "
                    + reload);
        }

        // 第一次加载时设置PROJECT_NAME的值(以后不可改变)
        PROJECT_NAME = props.getProperty("project.name");
    }

    /**
     * 从一个根路径下加载文件到props属性中
     */
    private static void loadConfigToProps(File file, Properties props) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                String absolutePath = decode(file.getAbsolutePath());
                String systemFileName = SYSTEM_PROPERTIES_PATH
                        .substring(SYSTEM_PROPERTIES_PATH.indexOf("/") + 1);

                // 排除掉META-INF/system.properties文件
                if (!absolutePath.contains(systemFileName)) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".properties")
                            && fileName.startsWith(PROJECT_NAME)) {
                        if (!lastModifiedProperties.containsKey(absolutePath)
                                || file.lastModified() > lastModifiedProperties
                                        .get(absolutePath)) {
                            lastModifiedProperties.put(absolutePath,
                                    file.lastModified());
                            Properties tmpProps = loadProperties(file);
                            mergeProperties(props, tmpProps);
                            logger.info("load config success: " + absolutePath);
                        }
                    }
                }
            } else {
                for (File f : file.listFiles()) {
                    loadConfigToProps(f, props);
                }
            }
        }
    }

    /**
     * 加载配置
     */
    private static void loadConfig() {
        InputStream inputStream = null;
        URL url = AppConfig.class.getClassLoader().getResource(
                SYSTEM_PROPERTIES_PATH);
        if (url == null) {
            String msg = "FileNotFoundException: " + SYSTEM_PROPERTIES_PATH;
            logger.fatal(msg);
            throwRuntimeException(msg);
        }
        try {
            /**
             * 加载classpath:META-INF/system.properties文件
             */
            String filepath = decode(url.getFile());
            File systemFile = new File(filepath);
            inputStream = new FileInputStream(systemFile);
            if (systemFile.lastModified() > lastModified) {
                props.load(inputStream);
                lastModified = systemFile.lastModified();
                logger.info("load config success: " + SYSTEM_PROPERTIES_PATH);
            }

            /**
             * 加载classpath:META-INF/**\/${project.name}.properties
             */
            loadConfigToProps(systemFile.getParentFile(), props);
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException: UTF-8");
            throwRuntimeException(e);
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException: " + SYSTEM_PROPERTIES_PATH);
            throwRuntimeException(e);
        } catch (IOException e) {
            logger.error("IOException: " + SYSTEM_PROPERTIES_PATH);
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
     * 用来在运行时改变系统是否启用动态加载system.properties功能
     */
    public static void setReaload(boolean reload) {
        AppConfig.reload = reload;
        logger.info("dynamic load " + SYSTEM_PROPERTIES_PATH + ": " + reload);
    }

    /**
     * 获得项目的工程名， 检测classpath:META-INF/system.properties中的project.name属性，
     * 系统将会根据检测值匹配以下路径规则的properties文件：
     * classpath:META-INF/**\/${project.name}-*.properties
     */
    public static String getProjectName() {
        return PROJECT_NAME;
    }

}