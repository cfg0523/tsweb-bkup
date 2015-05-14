package com.techsen.tsweb.core.util;

import static com.techsen.tsweb.core.util.CharCodeUtil.decode;
import static com.techsen.tsweb.core.util.CloseUtil.close;
import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Properties的工具类
 */
public class PropertiesUtil {
    private static Logger logger = Log4jUtil.getLogger(PropertiesUtil.class);
    
    /**
     * 从文件中加载Properties属性
     */
    public static Properties loadProperties(File file) {
        Properties props = null;
        String absolutePath = decode(file.getAbsolutePath());
        if (file != null && file.exists()) {
            props = new Properties();
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
                props.load(inputStream);
                logger.info("load file success: " + absolutePath);
            } catch (IOException e) {
                logger.error("IOException: " + absolutePath);
                throwRuntimeException(e);
            } finally {
                close(inputStream);
            }
        } else {
            String msg = "File not exists: " + absolutePath;
            logger.error(msg);
            throwRuntimeException(msg);
        }
        return props;
    }
    
    /**
     * 合并Properties
     */
    public static Properties mergeProperties(Properties target, Properties source) {
        if (target != null) {
            if (source != null) {
                for (Object objKey : source.keySet()) {
                    String key = (String) objKey;
                    if (!target.containsKey(key)) {
                        target.put(key, source.get(key));
                    } else {
                        String msg = "DuplicateKeyException: " + key;
                        logger.error(msg);
                        throwRuntimeException(msg);
                    }
                }
            }
            return target;
        } else {
            return source;
        }
    }
}
