package com.data.service;

import com.data.entity.LoginLog;
import com.data.mapper.LoginLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  7:46 PM
 * @description:
 */
@Service("loginLogService")
public class LoginLogService {
    @Autowired
    LoginLogMapper loginLogMapper;

    public int insertLoginlog(LoginLog loginLog) {
        int i = loginLogMapper.insertLoginLog(loginLog);
        return i;
    }
}
