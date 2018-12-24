package com.data.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "api-core")
public interface BannerService {

    @RequestMapping(value = "/selectBannerByTypeAndShows", method = RequestMethod.GET)
    public String selectBannerByTypeAndShows(@RequestParam(value = "type") Integer type, @RequestParam(value = "shows"
    ) String shows);
}
