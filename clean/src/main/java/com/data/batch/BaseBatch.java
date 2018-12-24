package com.data.batch;

import com.data.entity.KeyLibrary;
import com.data.entity.KeyWord;
import com.data.utils.DateUtils;
import com.data.utils.ReflectUtils;
import com.data.utils.StringUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : ganjiaxin
 * create at:  2018/12/21  11:23 AM
 * @description:
 */
public class BaseBatch {

    /*
     * 批量增加
     */
    public String batchAdd(Map map) {
        List<Object> list = (List<Object>) map.get("list");
        Object object = list.get(0);
        StringBuilder sb = new StringBuilder();
        sb.append("insert into " + ReflectUtils.getTableName(object.getClass()) + "(" + StringUtils.strip(ReflectUtils.getColumnName(object.getClass()).toString(), "[]") + ")" +
                " values");
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            sb.append("(" + StringUtils.strip(ReflectUtils.getObjectValue(o).toString(), "[]") + "),");
        }
        //去掉最后因为逗号
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /*
     * 批量刷新
     */
    public String batchReplace(Map map) {
        List<Object> list = (List<Object>) map.get("list");
        Object object = list.get(0);
        StringBuilder sb = new StringBuilder();
        sb.append("replace into " + ReflectUtils.getTableName(object.getClass()) + "(" + StringUtils.strip(ReflectUtils.getColumnName(object.getClass()).toString(), "[]") + ")" +
                " values");
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            sb.append("(" + StringUtils.strip(ReflectUtils.getObjectValue(o).toString(), "[]") + "),");
        }
        //去掉最后因为逗号
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
