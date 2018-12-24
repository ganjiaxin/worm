package com.data.service;

import com.data.entity.InvitetionUser;
import com.data.mapper.InvitetionUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  8:11 PM
 * @description:
 */
@Service("invitetionUserService")
public class InvitetionUserService {
    @Autowired
    InvitetionUserMapper invitetionUserMapper;

    public void save(InvitetionUser invitetionUser) {
        invitetionUserMapper.save(invitetionUser.getAddTime(), invitetionUser.getUserId(),
                invitetionUser.getInviteeId());
    }
}
