package com.data.controller;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.data.service.KeyLibraryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ganjiaxin
 * create at:  2018/12/26  4:20 PM
 * @description:
 */
@RestController
public class CardingSearchKeyLibrary {

    @Autowired
    KeyLibraryService keyLibraryService;


    @ApiOperation("关键词库热度数据梳理")
    @ApiImplicitParam(name = "array", value = "数据列表")
    @ResponseBody
    @RequestMapping(value = "/cardingSearchKeyLibrary", method = RequestMethod.POST)
    public void cardingSearchKeyLibrary(@RequestParam(value = "array", required = true) String array) {
        JSONArray jsonArray = JSON.parseArray(array);
        keyLibraryService.updateKeyLibrary(array);
    }
}
