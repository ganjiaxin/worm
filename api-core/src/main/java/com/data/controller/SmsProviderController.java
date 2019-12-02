package com.data.controller;

import com.data.entity.User;
import com.data.sms.SMSProvider;
import com.data.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  8:53 PM
 * @description:短信
 */
@RestController
@RequestMapping("/sms")
@Api(value = "短信", tags = "短信")
public class SmsProviderController {
    @Autowired
    SMSProvider smsProvider;

    @ApiOperation(value = "发送短信", notes = "发送短息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = false, paramType = "query", dataType =
                    "Integer"),
            @ApiImplicitParam(name = "randomCode", value = "验证码", required = false, paramType = "query", dataType =
                    "Integer")
    })
    @ResponseBody
    @RequestMapping("/sendVerifyMessage")
    public JSONObject sendVerifyMessage(@RequestParam(value = "phone") String phone,
                                        @RequestParam(value = "randomCode") String randomCode) {
        JSONObject jsonObject = null;
        try {
            jsonObject = smsProvider.sendVerifyMessage(phone, randomCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
