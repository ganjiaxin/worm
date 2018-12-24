package com.data.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : ganjiaxin
 * create at:  2018/12/20  9:29 PM
 * @description:
 */
@FeignClient(value = "collector")
public interface SoftwareService {

    @RequestMapping(value = "/getSearchSoftware", method = RequestMethod.GET)
    public String getSearchSoftware(@RequestParam(value = "term") String term, @RequestParam(value = "limit"
    ) String limit, @RequestParam(value = "country") String country);
}
