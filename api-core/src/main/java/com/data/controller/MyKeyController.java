package com.data.controller;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.data.entity.User;
import com.data.service.UserKeyService;
import com.data.service.UserService;
import com.data.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ganjiaxin
 * create at:  2018/12/20  8:53 PM
 * @description:KEY列表
 */
@RestController
@RequestMapping("/myKey")
@Api(value = "KEY列表", tags = "KEY列表")
public class MyKeyController {
    @Autowired
    UserKeyService userKeyService;

    @ApiOperation(value = "获取我的KEY", notes = "获取我的KEY")
    @ApiImplicitParam(name = "userId", value = "用户主键", required = false, paramType = "query", dataType =
            "Integer")
    @ResponseBody
    @RequestMapping(value = "/myKey", method = RequestMethod.GET)
    public String myKey(@RequestParam(value = "userId", required = true) Integer userId) {
        JSONArray array = userKeyService.getUserKey(userId);
        return JSON.toJSONString(array);
    }
}
