package com.data.controller;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.data.service.CardingSearchSoftwareService;
import com.data.service.SearchSoftwareService;
import com.data.utils.HttpClientUtil;
import com.data.utils.MapUrlParamsUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@Api(value = "应用采集类")
public class SearchSoftwareController {
    @Value("${search}")
    String searchUrl;

    @Autowired
    SearchSoftwareService searchSoftwareService;
    @Autowired
    CardingSearchSoftwareService cardingSearchSoftwareService;


    @ApiOperation(value = "应用采集")
    public void SearchSoftwareController(@RequestParam(value = "term", required = true) String term,
                                         @RequestParam(value = "country", defaultValue = "cn", required = true) String country,
                                         @RequestParam(value = "limit", defaultValue = "200", required = true) String limit) {
        Map map = new HashMap();
        map.put("media", "software");
        map.put("country", country);
        map.put("limit", limit);
        String obj = HttpClientUtil.doGet(searchUrl + MapUrlParamsUtils.getUrlParamsByMap(map), "UTF-8");
        JSONObject jsonObject = JSON.parseObject(obj);
        Integer resultCount = jsonObject.getInteger("resultCount");
        if (resultCount > 0) {
            String jsonArray = jsonObject.getString("results");
            //采集数据入库
            searchSoftwareService.insertSearchSoftware(term, jsonArray);
            //采集数据梳理
            cardingSearchSoftwareService.cardingSearchSoftware(term, jsonArray);

        }


    }


}
