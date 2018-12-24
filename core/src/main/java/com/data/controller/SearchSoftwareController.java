package com.data.controller;

import com.data.service.SearchSoftwareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/20  10:24 PM
 * @description:
 */
@Api(value = "应用类元数据入库", description = "应用类元数据入库")
@RestController
public class SearchSoftwareController {

    @Autowired
    SearchSoftwareService searchSoftwareService;

    @ApiOperation("应用类元数据入库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "term", value = "搜索关键字"),
            @ApiImplicitParam(name = "array", value = "数据数组")
    })
    @ResponseBody
    @RequestMapping(value = "/insertSearchSoftware",method = RequestMethod.POST)
    public Integer insertSearchSoftware(@RequestParam(value = "term") String term,
                                        @RequestParam(value = "array") String array) {
        Integer i = searchSoftwareService.insertSearchSoftware(term, array);
        return i;
    }
}
