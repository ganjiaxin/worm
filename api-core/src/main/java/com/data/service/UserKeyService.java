package com.data.service;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.data.mapper.UserKeyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserKeyService {
    @Autowired
    UserKeyMapper userKeyMapper;


    public JSONArray getUserKey(Integer userId) {
        Map map=userKeyMapper.selectUserKey(userId);

        return null;
    }
}
