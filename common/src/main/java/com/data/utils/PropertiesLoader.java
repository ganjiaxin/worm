package com.data.utils;

import com.data.des.DESEncryptUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * Properties文件载入工具类. 可载入多个properties文件, 相同的属性在最后载入的文件中的值将会覆盖之前的值，但以System的Property优先.
 * @author regan
 * @version 2013-05-15
 */
public class PropertiesLoader {

    private static Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    private final Properties properties;

    public PropertiesLoader(String... resourcesPaths) {
        properties = loadProperties(resourcesPaths);
    }

    public PropertiesLoader(String resourcesPath, String keyPath) {
        properties = loadPropertiesByKey(resourcesPath, keyPath);
    }

    public Properties getProperties() {
        return properties;
    }

    /**
     * 取出Property，但以System的Property优先,取不到返回空字符串.
     */
    private String getValue(String key) {
        String systemProperty = System.getProperty(key);
        if (systemProperty != null) {
            return systemProperty;
        }
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        }
        return "";
    }

    /**
     * 取出String类型的Property，但以System的Property优先,如果都为Null则抛出异常.
     */
    public String getProperty(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    /**
     * 取出String类型的Property，但以System的Property优先.如果都为Null则返回Default值.
     */
    public String getProperty(String key, String defaultValue) {
        String value = getValue(key);
        return value != null ? value : defaultValue;
    }

    /**
     * 取出Integer类型的Property，但以System的Property优先.如果都为Null或内容错误则抛出异常.
     */
    public Integer getInteger(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return Integer.valueOf(value);
    }

    /**
     * 取出Integer类型的Property，但以System的Property优先.如果都为Null则返回Default值，如果内容错误则抛出异常
     */
    public Integer getInteger(String key, Integer defaultValue) {
        String value = getValue(key);
        return value != null ? Integer.valueOf(value) : defaultValue;
    }

    /**
     * 取出Double类型的Property，但以System的Property优先.如果都为Null或内容错误则抛出异常.
     */
    public Double getDouble(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return Double.valueOf(value);
    }

    /**
     * 取出Double类型的Property，但以System的Property优先.如果都为Null则返回Default值，如果内容错误则抛出异常
     */
    public Double getDouble(String key, Integer defaultValue) {
        String value = getValue(key);
        return value != null ? Double.valueOf(value) : defaultValue;
    }

    /**
     * 取出Boolean类型的Property，但以System的Property优先.如果都为Null抛出异常,如果内容不是true/false则返回false.
     */
    public Boolean getBoolean(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return Boolean.valueOf(value);
    }

    /**
     * 取出Boolean类型的Property，但以System的Property优先.如果都为Null则返回Default值,如果内容不为true/false则返回false.
     */
    public Boolean getBoolean(String key, boolean defaultValue) {
        String value = getValue(key);
        return value != null ? Boolean.valueOf(value) : defaultValue;
    }

    /**
     * 载入多个文件, 文件路径使用Spring Resource格式.
     */
    private Properties loadProperties(String... resourcesPaths) {
        Properties props = new Properties();

        for (String location : resourcesPaths) {
            InputStream is = null;
            try {
                Resource resource = resourceLoader.getResource(location);
                is = resource.getInputStream();
                //props.load(in);//直接这么写，如果properties文件中有汉子，则汉字会乱码。因为未设置编码格式
                props.load(new InputStreamReader(is, "utf-8"));
            } catch (IOException ex) {
                logger.info("Could not load properties from path:" + location + ", " + ex.getMessage());
            } finally {
                IOUtils.closeQuietly(is);
            }
        }
        return props;
    }

    /**
     * DES加密文件读取
     * @param resourcesPath
     * @param keyPath
     * @return
     */
    private Properties loadPropertiesByKey(String resourcesPath, String keyPath) {
        Properties props = new Properties();

        InputStream is = null;
        try {
            Resource resource = resourceLoader.getResource(resourcesPath);
            Resource keyLocation = resourceLoader.getResource(keyPath);
            is = resource.getInputStream();
            Key key = DESEncryptUtil.getKey(keyLocation.getInputStream());
            is = DESEncryptUtil.doDecrypt(key, is);
            props.load(is);
        } catch (IOException ex) {
            logger.info("Could not load properties from path:" + resourcesPath + ", " + ex.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
        return props;
    }
}
