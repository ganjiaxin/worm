package com.data.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "clean")
public interface CardingSearchSoftwareService {

    /**
     * 采集数据梳理
     *
     * @param term
     * @param array
     * @return
     */
    @RequestMapping(value = "/CardingSearchSoftware", method = RequestMethod.POST)
    Integer cardingSearchSoftware(@RequestParam(value = "term", required = true) String term,
                                         @RequestParam(value = "array", required = true) String array);

}
