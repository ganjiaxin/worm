package com.data.service;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "clean")
public interface CardingSearchKeyLibraryService {

    @ApiOperation("关键词库热度数据梳理")
    @ApiImplicitParam(name = "array", value = "数据列表")
    @ResponseBody
    @RequestMapping(value = "/cardingSearchSoftware", method = RequestMethod.POST)
    Integer cardingSearchSoftware(@RequestParam(value = "array", required = true) String array);
}
