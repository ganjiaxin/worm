package com.data.controller.User;

import com.data.config.RedisUtil;
import com.data.constant.Constant;
import com.data.controller.BaseController;
import com.data.ret.Msg;
import com.data.sms.SMSProvider;
import com.data.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/sms")
@Api(value = "短信发送类", description = "短信发送类")
public class SmsController extends BaseController {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    SMSProvider smsProvider;

    @ApiOperation(value = "注册验证码发送")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = false, paramType = "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "token", value = "验证码TOKEN", required = false, paramType = "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "imgCodes", value = "图片验证码", required = false, paramType = "query", dataType =
                    "String")
    })
    @RequestMapping(value = "/sendRegistMobile", method = RequestMethod.POST)
    @ResponseBody
    public Msg sendMobile(@RequestParam(value = "phone", required = false) String phone,
                          @RequestParam(value = "token", required = false) String token,
                          @RequestParam(value = "imgCodes", required = false) String imgCodes) throws Exception {
        Msg msg = new Msg("0", "");
        //验证手机号码非空
        if (StringUtils.isBlank(phone)) {
            msg.setCode("-1004");
            return msg;
        }
        //验证图片验证码非空
        if (StringUtils.isBlank(imgCodes)) {
            msg.setCode("-1014");
            return msg;
        }
        //请获取图形验证码
        if (StringUtils.isBlank(token)) {
            msg.setCode("-1013");
            return msg;
        }
        // 手机号格式是否正确
        boolean ismobile = RegexUtil.isMobile(phone);
        if (!ismobile) {
            msg.setCode("-107");
            return msg;
        }

        String redisCode = (String) redisUtil.get(token + "imgVCode");
        if (StringUtils.isBlank(redisCode)) {
            msg.setCode("-1013");
            return msg;
        }
        if (!redisCode.equals(imgCodes.toLowerCase())) {
            msg.setCode("-1012");
            //图形验证码输入错误,删除图形验证.
            redisUtil.del(token + "imgVCode");
            return msg;
        }


        String key = Constant.PHONE_REG_CODE_PREFIX + phone;
        Object code = redisUtil.get(key);
        if (code != null) {
            // 判断如果请求间隔小于一分钟则请求失败
            if (!BigDecimalUtils.compare(DateUtils.diffMinute((Date) redisUtil.get(key + "Time")), BigDecimal.ONE)) {
                msg.setCode("-10142");
                return msg;
            }
        }
        String randomCode = String.valueOf(GeneratorUtil.getRandomNumber(100000, 999999));
        if (!RegexUtil.isMobile(phone.trim())) {
            msg.setCode("-107");
            return msg;
        }
        JSONObject jsonObject = JSONObject.fromObject(smsProvider.sendVerifyMessage("86" + phone, randomCode));
        if ("0".equals(jsonObject.get("code"))) {
            redisUtil.del(key);
            redisUtil.del(key + "Time");
            // 缓存验证码
            redisUtil.set(key, randomCode, 10 * 60);
            redisUtil.set(key + "Time", new Date(), 10 * 60);
            return msg;
        }
        return msg;
    }


}