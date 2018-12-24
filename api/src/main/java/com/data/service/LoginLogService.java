package com.data.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@FeignClient(value = "api-core")
public interface LoginLogService {

    @RequestMapping("/insertLoginlog")
    void insertLoginlog(@RequestParam(value = "device") String device, @RequestParam(value = "ip") String ip,
                        @RequestParam(value = "addTime") Date addTime, @RequestParam(value = "id") Integer id,
                        @RequestParam(value = "state") Integer state, @RequestParam(value = "msg") String msg);
}
