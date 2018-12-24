package com.data.utils;


import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 消息配置
 *
 * @author : ganjiaxin
 * create at:  2018/12/11  11:26 AM
 * @description:
 */
public class MessageUtil {

    /**
     * 当前实例对象
     */
    private static MessageUtil messageUtil = new MessageUtil();

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader loader = new PropertiesLoader("message.properties");

    public static MessageUtil getInstance() {
        return messageUtil;
    }

    /**
     * 获取提示消息
     *
     * @param key
     * @return
     */
    public static String getMessage(String key) {
        String value = map.get(key);
        if (StringUtils.isBlank(value)) {
            value = loader.getProperty(key);
            map.put(key, value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }
}
