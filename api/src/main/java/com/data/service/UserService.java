package com.data.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.sf.json.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@FeignClient(value = "api-core")
public interface UserService {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String login(@RequestParam(value = "userName") String userName,
                     @RequestParam(value = "password") String password);

    @RequestMapping(value = "/findByKey", method = RequestMethod.GET)
    String findByKey(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "/findByMobile", method = RequestMethod.GET)
    String findByMobile(@RequestParam(value = "mobile") String mobile);



    @RequestMapping(value = "/saveByPhone", method = RequestMethod.POST)
    int saveByPhone(@RequestParam(value = "salt") String salt, @RequestParam(value = "userName") String userName,
                     @RequestParam(value = "addIp") String addIp, @RequestParam(value = "addTime") String addTime,
                     @RequestParam(value = "mobile") String mobile,
                     @RequestParam(value = "hexPassword") String hexPassword,
                     @RequestParam(value = "myInvitationCode") String myInvitationCode, @RequestParam(value =
            "invitationCode") String invitationCode);

    @RequestMapping(value = "/findByInvitationCode", method = RequestMethod.GET)
    String findByInvitationCode(@RequestParam(value = "invitationCode") String invitationCode);
}
