package com.data.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.collections.map.ListOrderedMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  12:28 PM
 * @description:
 */
public class JsonUtils {
    /**
     * json字符串转化为XML
     *
     * @param strJson json字符串
     * @return
     */
    public static String json2xml(String strJson) {
        JSONObject obj = JSONObject.fromObject(strJson, JsonUtils.cfg());
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setTypeHintsEnabled(false);
        xmlSerializer.setRootName("root");
        String xml = xmlSerializer.write(obj);
        return xml;
    }

    /**
     * 没有登录的JSON数据
     *
     * @param text 提示
     * @return
     */
    public static String getFailureLoginJSON(String text, String requestURL) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("failure:true, error: '" + text + "',loginUrl:'/main/login.jsp?from=" + requestURL + "'");

        sb.append("}");
        return sb.toString();
    }

    /**
     * 失败文本的JSON数据
     *
     * @param text 提示
     * @return
     */
    public static String getFailureJSON(String text) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");

        sb.append("failure:true, error: '" + text + "'");

        sb.append("}");
        return sb.toString();
    }

    /**
     * 失败文本的JSON数据
     *
     * @param errorCode 错误编号
     * @param text      提示
     * @return
     */
    public static String getFailureJSON(String errorCode, String text) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");

        sb.append("failure:true, error: '" + text + "', errorCode:'").append(errorCode).append("'");

        sb.append("}");
        return sb.toString();
    }

    /**
     * 成功文本的JSON数据
     *
     * @param text 提示
     * @return
     */
    public static String getSuccessJSON(String text) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("success:true, data: '" + text + "'");
        sb.append("}");
        return sb.toString();
    }

    /**
     * 将对象转换成JSON数据
     *
     * @param o 待转换对象
     * @return
     */
    public static String getJSONArrayFromObject(Object o) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        if (o != null) {

            sb.append("success:true, data:");
            sb.append(JSONObject.fromObject(o, cfg()).toString());
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * 将列表，记录总数转换成JSON数据
     *
     * @param total 记录总数
     * @param o     列表
     * @return
     */
    public static String getJSONArrayFromList(int total, Object o) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        if (o != null) {
            sb.append("success:true, ");
            sb.append("total:\'");
            sb.append(total);
            sb.append("\',root:");
            sb.append(JSONArray.fromObject(o, cfg()).toString());
        }
        sb.append("}");
        return sb.toString();

    }

    /**
     * 将对象List,array转换成JSON数据
     *
     * @param o
     * @return
     */
    public static String getJSONArrayFromList(Object o) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        if (o != null) {
            sb.append("success:true, data:");
            sb.append(JSONArray.fromObject(o, cfg()).toString());
        }
        sb.append("}");
        return sb.toString();
    }

    // 重新设置时间格式
    public static JsonConfig cfg() {
        JsonConfig cfg = new JsonConfig();
        cfg.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessorImpl("yyyy-MM-dd HH:mm:ss"));
        cfg.registerJsonValueProcessor(java.sql.Date.class, new JsonValueProcessorImpl("yyyy-MM-dd HH:mm:ss"));
        cfg.registerJsonValueProcessor(java.sql.Timestamp.class, new JsonValueProcessorImpl("yyyy-MM-dd HH:mm:ss"));
        //cfg.registerJsonValueProcessor(java.lang.Float.class, new JsonFloatPointNumberProcessor());
        //cfg.registerJsonValueProcessor(java.lang.Double.class, new JsonFloatPointNumberProcessor());
        return cfg;
    }

    public static String listToJson(Object o) {
        String str = "[]";
        str = JSONArray.fromObject(o, cfg()).toString();
        return str;
    }

    /**
     * 将列表，对像转换成JSON数据
     *
     * @param o 数据对象
     * @return
     */
    public static String fromObject(Object o) {
        String jsonString = JSONArray.fromObject(o, cfg()).toString();
        return jsonString.substring(1, jsonString.length() - 1);
    }

    /**
     * 返回map键值对的成功提示信息
     *
     * @param map
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getSuccessJSON(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("success:true,");
        Map.Entry<String, String> entry = null;
        for (Object o : map.entrySet()) {
            Map.Entry<String, String> o2 = (Map.Entry<String, String>) o;
            entry = o2;
            sb.append(entry.getKey() + ":'" + entry.getValue() + "', ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}");
        return sb.toString();
    }

    /**
     * .
     *
     * @param obj .
     * @return .
     */
    public static final String toJSONString(final Object obj) {
        return JSONObject.fromObject(obj).toString();
    }

    public static final <T> Object toObject(String json, Class<T> clzz) {
        JSONObject object = JSONObject.fromObject(json);
        return JSONObject.toBean(object, clzz);
    }

    public static final Object toObject(String json) {
        JSONObject object = JSONObject.fromObject(json);
        return JSONObject.toBean(object);
    }

    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> parseJSON2List(String jsonStr) {
        JSONArray jsonArr = JSONArray.fromObject(jsonStr);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Iterator<JSONObject> it = jsonArr.iterator();
        while (it.hasNext()) {
            JSONObject json2 = it.next();
            list.add(parseJSON2Map(json2.toString()));
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseJSON2Map(String jsonStr) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 最外层解析
        JSONObject json = JSONObject.fromObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解析
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<JSONObject> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }

    public static Map<String, String> parseJSON2StringMap(String jsonStr) {
        Map<String, String> map = new HashMap<String, String>();
        // 最外层解析
        JSONObject json = JSONObject.fromObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解析
            map.put(k.toString(), v.toString());
        }
        return map;
    }

    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }

    /**
     * json转换map.
     *
     * @param jsonStr
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> toMap(String jsonStr) {
        @SuppressWarnings("rawtypes")
        ListOrderedMap map = new ListOrderedMap();
        // 最外层解析
        JSONObject json = JSONObject.fromObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解析
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<JSONObject> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }

}
