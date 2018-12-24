package com.data.controller;

import com.data.entity.LoginLog;
import com.data.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  8:03 PM
 * @description:
 */
@RestController
public class LoginLogController {
    @Autowired
    LoginLogService loginLogService;

    @RequestMapping("/insertLoginlog")
    public int insertLoginlog(String device, String ip, Date addTime, Integer id, Integer status, String remark) {
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
