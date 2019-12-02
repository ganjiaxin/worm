package com.data.service;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import com.data.entity.KeyLibrary;
import com.data.mapper.KeyLibraryMapper;
import com.data.mapper.KeyWordMapper;
import com.data.utils.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/21  2:36 PM
 * @description:
 */
@Service("keyLibraryService")
public class KeyLibraryService {

    @Autowired
    KeyLibraryMapper keyLibraryMapper;


    /**
     * 查询关键词主键
     *
     * @param keyName
     * @return
     */
    public Integer selectKeyLibrary(String keyName) {
        Integer id = keyLibraryMapper.selectKeyLibrary(keyName);
        return id;
    }

    /**
     * 关键词库插入
     *
     * @param keyName
     * @return
     */
    public Integer insertKeyLibrary(String keyName) {
        Integer id = keyLibraryMapper.insertKeyLibrary(keyName);
        return id;
    }


    /**
     * 更新关键词库
     *
     * @param array
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateKeyLibrary(String array) {
        JSONArray jsonArray = JSON.parseArray(array);
        List<KeyLibrary> list = new ArrayList<KeyLibrary>();
        Date updateTime = DateUtils.getNow();
        for (Object o : jsonArray) {
            JSONObject object = JSON.parseObject(JSON.toJSONString(o));
            keyLibraryMapper.updateKeyLibrary(object.getInteger("fiery"), object.getString("term"), updateTime);
        }
    }


}
