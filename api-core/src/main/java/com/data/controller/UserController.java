package com.data.controller;

import com.data.entity.User;
import com.data.service.UserService;
import com.data.utils.DateUtils;
import com.data.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  6:08 PM
 * @description:
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "password") String password) {
        User user = userService.login(userName, password);
        String jsonObject = JsonUtils.getJSONArrayFromObject(user);
        return jsonObject;
    }

    @RequestMapping("/findByKey")
    public String login(@RequestParam(value = "id") Integer id) {
        User user = userService.findByKey(id);
        String jsonObject =
                JsonUtils.getJSONArrayFromObject(user);
        return jsonObject;
    }

    @RequestMapping("/findByMobile")
    public String findByMobile(@RequestParam(value = "mobile") String mobile) {
        User user = userService.findByMobile(mobile);
        if (user != null) {
            String jsonObject =
                    JsonUtils.getJSONArrayFromObject(user);
            return jsonObject;
        } else {
            return null;
        }
    }

    @RequestMapping("/saveByPhone")
    public Integer saveByPhone(@RequestParam(value = "salt") String salt,
                               @RequestParam(value = "userName") String userName,
                               @RequestParam(value = "addIp") String addIp,
                               @RequestParam(value = "addTime") String addTime,
                               @RequestParam(value = "mobile") String mobile,
                               @RequestParam(value = "hexPassword") String hexPassword,
                               @RequestParam(value = "myInvitationCode") String myInvitationCode,
                               @RequestParam(value = "invitationCode") String invitationCode) {
        Integer i = userService.saveByPhone(salt, userName, addIp, DateUtils.parseDate(addTime), mobile, hexPassword,
                myInvitationCode, invitationCode);
        return i;
    }
}
