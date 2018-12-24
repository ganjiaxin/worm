package com.data.sms;

import net.sf.json.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "api-core")
public interface SMSProvider {

    @RequestMapping(value = "/sendVerifyMessage", method = RequestMethod.POST)
    public String sendVerifyMessage(@RequestParam(value = "phone") String phone,
                                    @RequestParam(value = "randomCode") String randomCode);

}
