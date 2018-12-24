package com.data.mapper;

import com.data.entity.LoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginLogMapper {

    @Insert("insert into  login_log(login_device,login_ip,login_time,uid) VALUES(#{loginDevice},#{loginIp}," +
            "#{loginTime},#{uid})")
    int insertLoginLog(LoginLog loginLog);
}
