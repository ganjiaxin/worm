package com.data.controller;

import com.data.entity.User;
import com.data.sms.SMSProvider;
import com.data.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  8:53 PM
 * @description:
 */
@RestController
public class SMSProviderController {
    @Autowired
    SMSProvider smsProvider;

    @RequestMapping("/sendVerifyMessage")
    public JSONObject sendVerifyMessage(@RequestParam(value = "phone") String phone, @RequestParam(value =
            "randomCode") String randomCode) {
        JSONObject jsonObject = null;
        try {
            jsonObject = smsProvider.sendVerifyMessage(phone, randomCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
