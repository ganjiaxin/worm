package com.data.service;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import com.data.entity.KeyWord;
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
 * create at:  2018/12/21  10:51 AM
 * @description:
 */
@Service("keyWordService")
public class KeyWordService {
    @Autowired
    KeyWordMapper keyWordMapper;

    /**
     * 更新关键词和应用排名表
     *
     * @param keyId
     * @param term
     * @param jsonArray
     * @return
     */
    @Transactional(rollbackFor =Exception.class)
    public void batchInsertKeyWord(Integer keyId, String term, JSONArray jsonArray) {
        Date addTime = DateUtils.getNow();
        List<KeyWord> list = new ArrayList<KeyWord>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Integer position = i + 1;
            Integer n = keyWordMapper.selectKeyWord(jsonObject.getInteger("trackId"), "cn", keyId);
            if (n > 0) {
                keyWordMapper.updateKeyWord(jsonObject.getInteger("trackId"), position, "cn", addTime, keyId);
            } else {
                keyWordMapper.insertKeyWord(term, jsonObject.getInteger("trackId"),
                        position, "cn",
                        addTime, addTime,
                        keyId, 0);
            }
        }
    }

}
