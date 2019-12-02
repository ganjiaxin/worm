package com.data.context;

import com.data.constant.Constant;
import com.data.ret.Msg;
import com.data.utils.StringUtils;
import com.google.common.collect.Maps;
import eu.bitwalker.useragentutils.DeviceType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  7:52 PM
 * @description: 全局配置类
 */
public class Global {
    /**
     * 当前对象实例
     */
    private static Global global = new Global();

    /**
     * 用户访问IP
     */
    public static ThreadLocal<String> IP_THREADLOCAL = new ThreadLocal<String>();

    /**
     * 接口回调处理结果
     */
    public static Map<String, Msg> MSG_MAP = Collections.synchronizedMap(new HashMap<String, Msg>());


    /**
     * 传输数据
     */
    public static final ThreadLocal<Map<String, Object>> transferThreadLocal = new ThreadLocal<Map<String, Object>>();

    /**
     * 保存系统参数全局属性值
     */
    private static Map<String, String> SYS_MAP = Maps.newHashMap();


    /**
     * 获取当前对象实例
     */
    public static Global getInstance() {
        return global;
    }


    /**
     * 获取IP
     *
     * @return
     */
    public static String getIP() {
        Object retObj = Global.IP_THREADLOCAL.get();
        String ip = retObj == null ? "" : retObj.toString();
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (StringUtils.isNotBlank(ip)) {
            return ip.split(",")[0];
        }
        return ip;
    }





    public static Map<String, Object> getTransfer() {
        Map<String, Object> map = (Map<String, Object>) transferThreadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            transferThreadLocal.set(map);
        }
        return map;
    }

    public static void setTransfer(String key, Object value) {
        Map<String, Object> map = getTransfer();
        map.put(key, value);
        transferThreadLocal.set(map);
    }

}
