package com.data.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "core")
public interface SearchSoftwareService {

    /**
     * 采集数据入库
     *
     * @param term
     * @param array
     * @return
     */
    @RequestMapping(value = "/insertSearchSoftware", method = RequestMethod.POST)
    Integer insertSearchSoftware(@RequestParam(value = "term", required = true) String term,
                                 @RequestParam(value = "array", required = true) String array);
}




