package com.data.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.service.CardingSearchKeyLibraryService;
import com.data.utils.HttpClientUtil;
import com.data.utils.MapUrlParamsUtils;
import com.data.utils.XmlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ganjiaxin
 * create at:  2018/12/26  3:59 PM
 * @description: 关键词热度采集
 */
@RestController
@Api(value = "关键词热度采集")
public class SearchKeyLibraryController {
    @Value("${keyLibrary}")
    private String keyLibrary;
    @Autowired
    CardingSearchKeyLibraryService cardingSearchKeyLibraryService;

    @ApiOperation(value = "应用采集")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "term"),
            @ApiImplicitParam(name = "country"),
            @ApiImplicitParam(name = "limit")
    })
    @RequestMapping(value = "/SearchKeyLibrary", method = RequestMethod.GET)
    public void SearchKeyLibraryController(@RequestParam(value = "term", required = true) String term,
                                           @RequestParam(value = "cc", defaultValue = "cn", required = true) String cc) {
        Map map = new HashMap();
        map.put("clientApplication", "Software");
        map.put("e", "true");
        map.put("media", "software");
        map.put("cc", cc);
        map.put("term", term);
        String obj = HttpClientUtil.doGet(keyLibrary + MapUrlParamsUtils.getUrlParamsByMap(map), "UTF-8");
        JSONArray array =
                JSON.parseObject(JSON.parseObject(XmlUtil.xml2JSON(obj.getBytes()).getJSONObject("plist").getJSONArray("dict").get(0).toString()).getJSONArray("array").get(0).toString()).getJSONArray("dict");
        JSONArray jsonArray = new JSONArray();
        for (Object o : array) {
            JSONObject object = JSON.parseObject(o.toString());
            JSONArray stringArray = object.getJSONArray("string");
            JSONArray integerArray = object.getJSONArray("integer");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("term", stringArray.get(0));
            jsonObject.put("fiery", integerArray.get(0));
            jsonArray.add(jsonObject);
        }
        //key库数据清理
        cardingSearchKeyLibraryService.cardingSearchSoftware(jsonArray.toJSONString());

    }

}
