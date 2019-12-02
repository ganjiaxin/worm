package com.data.controller;

import com.data.entity.LoginLog;
import com.data.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  8:03 PM
 * @description:登录日志
 */
@RestController
@RequestMapping("/loginLog")
@Api(value = "登录日志", tags = "登录日志")
public class LoginLogController {
    @Autowired
    LoginLogService loginLogService;


    @ApiOperation(value = "插入日志", notes = "插入日志")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "device", value = "类型", required = false, paramType = "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "ip", value = "IP", required = false, paramType = "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "addTime", value = "时间", required = false, paramType = "query", dataType =
                    "data"),
            @ApiImplicitParam(name = "id", value = "主键", required = false, paramType = "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "status", value = "状态", required = false, paramType = "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query", dataType =
                    "String")
    })
    @ResponseBody
    @RequestMapping("/insertLoginlog")
    public int insertLoginlog(@RequestParam(value = "device") String device,
                              @RequestParam(value = "addTime") String ip,
                              @RequestParam(value = "addTime") Date addTime,
                              @RequestParam(value = "id") Integer id,
                              @RequestParam(value = "status") Integer status,
                              @RequestParam(value = "remark") String remark) {
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginDevice(device);
        loginLog.setLoginIp(ip);
        loginLog.setLoginTime(addTime);
        loginLog.setUid(String.valueOf(id));
        loginLog.setStatus(status);
        loginLog.setRemark(remark);
        return loginLogService.insertLoginlog(loginLog);
    }
}
