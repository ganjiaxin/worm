package com.data.hystric;

import com.data.service.UserService;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  10:41 PM
 * @description:
 */
public class UserServiceHystric implements UserService {
    @Override
    public String login(String userName, String password) {
        return null;
    }

    @Override
    public String findByKey(Integer id) {
        return null;
    }

    @Override
    public String findByMobile(String mobile) {
        return null;
    }

    @Override
    public int saveByPhone(String salt, String userName, String addIp, String addTime, String mobile,
                           String hexPassword, String myInvitationCode, String invitationCode) {
        return 0;
    }

    @Override
    public String findByInvitationCode(String invitationCode) {
        return null;
    }
}
