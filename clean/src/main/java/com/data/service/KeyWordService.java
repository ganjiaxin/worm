package com.data.service;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import com.data.entity.KeyWord;
import com.data.mapper.KeyWordMapper;
import com.data.utils.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/21  10:51 AM
 * @description:
 */
@Service
public class KeyWordService {
    @Autowired
    KeyWordMapper keyWordMapper;

    /**
     * 更新关键词表
     *
     * @param keyId
     * @param term
     * @param jsonArray
     * @return
     */
    public Integer batchInsertKeyWord(Integer keyId, String term, JSONArray jsonArray) {
        Date addTime = DateUtils.getNow();
        List<KeyWord> list = new ArrayList<KeyWord>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Integer position = i + 1;
            KeyWord keyWord = new KeyWord();
            keyWord.setKeyId(keyId);
            keyWord.setKeyName(term);
            keyWord.setRanking(position);
            keyWord.setAddTime(addTime);
            keyWord.setUpdateTime(addTime);
            keyWord.setTrackId(Integer.valueOf(jsonObject.getString("trackId")));
            list.add(keyWord);
        }
        Integer i = keyWordMapper.batchInsertKeyWord(list);
        return i;
    }

}
