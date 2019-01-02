package com.data.controller;

import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONArray;
import com.data.entity.KeyLibrary;
import com.data.entity.KeyWord;
import com.data.service.ArtistService;
import com.data.service.KeyLibraryService;
import com.data.service.KeyWordService;
import com.data.service.TrackService;
import com.data.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/21  2:21 PM
 * @description:
 */
@RestController
public class CardingSearchSoftware {

    @Autowired
    KeyWordService keyWordService;
    @Autowired
    KeyLibraryService keyLibraryService;
    @Autowired
    TrackService trackService;
    @Autowired
    ArtistService artistService;

    @ApiOperation("应用数据梳理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "term", value = "搜索关键字"),
            @ApiImplicitParam(name = "array", value = "数据列表"),
    })
    @ResponseBody
    @RequestMapping(value = "/cardingSearchSoftware", method = RequestMethod.POST)
    public void cardingSearchSoftware(@RequestParam(value = "term", required = true) String term,
                                      @RequestParam(value = "array", required = true) String array) {

        JSONArray jsonArray = JSON.parseArray(array);
        Integer keyId = keyLibraryService.selectKeyLibrary(term);
        //如果关键词不存在,那么录入关键词.
        if (keyId == null) {
            keyLibraryService.insertKeyLibrary(term);
        }
        //更新关键词与应用排名表
        keyWordService.batchInsertKeyWord(keyId, term, jsonArray);
        //更新应用表
        trackService.replaceTrack(jsonArray);
        //更新发行商表
        artistService.replaceArtist(jsonArray);
    }
}
