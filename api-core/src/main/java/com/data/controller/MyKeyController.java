package com.data.controller;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.data.entity.User;
import com.data.service.UserKeyService;
import com.data.service.UserService;
import com.data.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ganjiaxin
 * create at:  2018/12/20  8:53 PM
 * @description:
 */
@RestController
public class MyKeyController {
    @Autowired
    UserKeyService userKeyService;

    @RequestMapping(value = "/myKey", method = RequestMethod.GET)
    public String myKey(Integer userId) {
       JSONArray array= userKeyService.getUserKey(userId);
        return JSON.toJSONString(array);
    }
}
