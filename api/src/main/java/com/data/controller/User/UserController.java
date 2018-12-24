package com.data.controller.User;

import com.data.base.BaseModel;
import com.data.config.RedisUtil;
import com.data.constant.Constant;
import com.data.context.Global;
import com.data.service.LoginLogService;
import com.data.service.UserService;
import com.data.ret.Msg;
import com.data.controller.BaseController;
import com.data.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONException;
import org.apache.commons.codec.digest.DigestUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  2:31 PM
 * @description:
 */
@Api(value = "用户相关类", description = "用户相关类")
@RestController
public class UserController extends BaseController {
    @Autowired
    UserService userService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    LoginLogService loginLogService;

    @CrossOrigin
    @ApiOperation(value = "登陆")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "userName", value = "用户名", required = false, paramType = "query", dataType =
                    "String"), @ApiImplicitParam(name = "password", value = "密码", required = false, paramType = "query",
                    dataType = "String")
            }
    )
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Msg login(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value =
            "password", required = false) String password, BaseModel model) throws JSONException {
        Msg msg = new Msg("0", "");
        if (StringUtils.isBlank(userName)) {
            msg.setCode("-1007");
            return msg;
        }
        if (StringUtils.isBlank(password)) {
            msg.setCode("-1001");
            return msg;
        }
        JSONObject json = JSONObject.fromObject(userService.login(userName, password));
        if (json != null) {
            //判断用户是否存在
            String hexPassword = DigestUtils.md5Hex(password + json.getString("salt"));
            //判断密码是否正确
            if (json.getString("password").equals(hexPassword)) {
                String token = IdGen.uuid();
                // 以token为键放入用户信息
                redisUtil.set(json.getString("id"), json, 0);
                // 有效期60分钟
                redisUtil.set(token, json, 60 * 60);
                msg.setData(json);
            } else {
                msg.setCode("-1009");
                loginLogService.insertLoginlog(model.getDevice(), Global.getIP(), DateUtils.getNow(), json.getInt("id"
                ), Constant.NO, msg.getMsg());
            }
        } else {
            msg.setCode("-10051");
            loginLogService.insertLoginlog(model.getDevice(), Global.getIP(), DateUtils.getNow(), json.getInt("id"),
                    Constant.NO, msg.getMsg());

        }
        return msg;
    }


    @CrossOrigin
    @ApiOperation(value = "手机号码注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phoneCode", value = "手机验证码", required = false, paramType = "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "mobile", value = "手机号", required = false, paramType = "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "userName", value = "用户昵称", required = false, paramType = "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = false, paramType = "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "invitationCode", value = "推荐人邀请码", required = false, paramType = "query",
                    dataType = "String")})
    @RequestMapping(value = "/registerByPhone", method = RequestMethod.POST)
    public Msg registerByPhone(@RequestParam(value = "phoneCode", required = false) String phoneCode,
                               @RequestParam(value = "mobile", required = false) String mobile,
                               @RequestParam(value = "userName", required = false) String userName,
                               @RequestParam(value = "password", required = false) String password,
                               @RequestParam(value = "invitationCode", required = false) String invitationCode) {
        Msg msg = new Msg("0", "");
        // 信息是否齐全
        if (StringUtils.isBlank(mobile) || StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            msg.setCode("-105");
            return msg;
        }
        //短信验证码非空校验
        if (StringUtils.isBlank(phoneCode)) {
            msg.setCode("-1010");
            return msg;
        }
        // 验证用户名格式
        if (userName.length() > 10) {
            msg.setCode("-10052");
            return msg;
        }
        // 手机号格式是否正确
        boolean ismobile = RegexUtil.isMobile(mobile);
        if (!ismobile) {
            msg.setCode("-107");
            return msg;
        }
        // 手机号是否注册
        JSONObject jsonObject = JsonUtils.stringtoJson(userService.findByMobile(mobile));
        if (jsonObject != null) {
            msg.setCode("-1005");
            return msg;
        }
        // 验证密码格式
        if (!RegexUtil.isPassword(password)) {
            msg.setCode("-10011");
            return msg;
        }
        // 校验验证码
        String phoneAndType = Constant.PHONE_REG_CODE_PREFIX + mobile;
        String reidsPhoneCode = (String) redisUtil.get(phoneAndType);
        if (StringUtils.isBlank(reidsPhoneCode)) {
            msg.setCode("-1016");
            return msg;
        }
        if (!phoneCode.equals(reidsPhoneCode)) {
            msg.setCode("-1015");
            return msg;
        }
        // 邀请码是否存在
        if (StringUtils.isNotBlank(invitationCode)) {
            JSONObject invitationUser = JSONObject.fromObject(userService.findByInvitationCode(invitationCode));
            if (invitationUser == null) {
                msg.setCode("-10053");
                return msg;
            }
        }
        String salt = GeneratorUtil.getNonceString(6);
        String hexPassword = DigestUtils.md5Hex(password + salt);
        Date addTime = DateUtils.getNow();
        String addIp = "";//Global.getIP();
        String myInvitation_code = GeneratorUtil.getNonceString(6);
        // 注册保存到数据库
        userService.saveByPhone(salt, userName, addIp, DateUtils.dateStr4(addTime), mobile, hexPassword,
                myInvitation_code, invitationCode);
        redisUtil.del(Constant.PHONE_REG_CODE_PREFIX + mobile);
        return msg;
    }


    @ApiOperation(value = "获取图形验证码")
    @RequestMapping(value = "/authImage", method = RequestMethod.GET)
    public Map<String, Object> authImage(HttpServletResponse response) throws Exception {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        // 生成随机字串
        String code = VerifyCodeUtils.generateVerifyCode(4);
        String token = GeneratorUtil.getUUID();
        redisUtil.set(token + "imgVCode", code.toLowerCase(), 60 * 2);
        // 生成图片
        int w = 140, h = 40;

        // Map<String, Object> map = VerifyCodeUtils.VerifyCode(w, h, 4,redisUtil);
        BASE64Encoder encoder = new BASE64Encoder();
        Map<String, Object> rs = new HashMap<>();
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(w, h, data, code);
        System.out.println(code);
        rs.put("image", "data:image/gif;base64," + encoder.encode(data.toByteArray()).replaceAll("\r\n", ""));
        rs.put("token", token);
        return rs;
    }


}
