package com.data.service;

import com.data.entity.InvitetionUser;
import com.data.entity.User;
import com.data.mapper.InvitetionUserMapper;
import com.data.mapper.UserMapper;
import com.data.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  6:06 PM
 * @description:
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    InvitetionUserMapper invitetionUserMapper;
//    @Autowired
//    AccountMapper accountMapper;
//    @Autowired
//    IdentifyMapper identifyMapper;
//    @Autowired
//    WalletMapper walletMapper;

    /**
     * 用户登陆
     *
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName, String password) {
        User user = userMapper.selectUserUserNameOrMobile(userName);
        return user;
    }

    /**
     * 查询手机号码
     *
     * @param mobile
     * @return
     */
    public User findByMobile(String mobile) {
        User user = userMapper.selectUserMobile(mobile);
        return user;
    }

    public User findByKey(Integer id) {
        User user = userMapper.selectByKey(id);
        return user;
    }

    public User findByMobileOrEmail(String mobile) {
        User user = userMapper.selectUserMobileOrEmail(mobile);
        return user;
    }

    public User findByInvitationCode(String invitation_code) {
        User user = userMapper.findByInvitationCode(invitation_code);
        return user;
    }

    public void save(User user) {
        userMapper.save(user);
    }

    /**
     * 手机注册，保存邀请关系
     *
     * @param salt             密钥
     * @param userName         用户名称
     * @param addIp            添加IP
     * @param add_time         添加时间
     * @param mobile           手机号码
     * @param hexPassword      密文密码
     * @param myInvitationCode 邀请码
     * @param invitationCode   推荐人邀请码
     */
    @Transactional
    public Integer saveByPhone(String salt, String userName, String addIp, Date add_time,
                               String mobile, String hexPassword, String myInvitationCode, String invitationCode) {
        int i=userMapper.saveByPhone(salt, userName, hexPassword, mobile, add_time, addIp, myInvitationCode);
        // 添加邀请关系
        User user = userMapper.selectUserMobile(mobile);
        if (StringUtils.isNotBlank(invitationCode)) {
            InvitetionUser invitetionUser = new InvitetionUser();
            User byInvitation_code = userMapper.findByInvitationCode(invitationCode);

            invitetionUser.setUserId(byInvitation_code.getId());
            Date addinviteTime = new Date();
            invitetionUser.setAddTime(addinviteTime);
            invitetionUser.setInviteeId(user.getId());
            invitetionUserMapper.save(addinviteTime, byInvitation_code.getId(), user.getId());
        }

        return i;
    }

//    /**
//     * 邮箱注册，保存邀请关系
//     *
//     * @param salt             密钥
//     * @param userName         用户名
//     * @param addIp            添加IP
//     * @param addTime          添加时间
//     * @param email            邮箱
//     * @param hexPassword      密文密码
//     * @param myInvitationCode 邀请码
//     * @param invitationCode   推荐人邀请码
//     */
//    public void saveByEmail(String salt, String userName, String addIp, Date addTime,
//                            String email, String hexPassword, String myInvitationCode, String invitationCode) {
//        userMapper.saveByEmail(salt, userName, hexPassword, email, addTime, addIp,
//                myInvitationCode);
//        // 添加邀请关系
//        User user = userMapper.selectUserEmail(email);
//        if (invitationCode != null) {
//            InvitetionUser invitetionUser = new InvitetionUser();
//            User byInvitationCode = userMapper.findByInvitationCode(invitationCode);
//
//            invitetionUser.setUserId(byInvitationCode.getId());
//            Date addinviteTime = new Date();
//            invitetionUser.setAddTime(addinviteTime);
//            invitetionUser.setInviteeId(user.getId());
//            invitetionUserMapper.save(addinviteTime, byInvitationCode.getId(), user.getId());
//        }
//        //添加账户
//        accountMapper.save(user.getId(), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));
//        //添加认证信息(全为0未认证)
//        identifyMapper.save(user.getId(), 0, 0, 0);
//        //添加pet宠物蛋
//
//    }

    public User findByEmail(String email) {
        User user = userMapper.selectUserEmail(email);
        return user;
    }

    /**
     * 手机重置密码
     *
     * @param password
     * @param mobile
     * @return
     */
    public int updatePassword(String password, String mobile) {
        int i = userMapper.updateUesrPassword(password, mobile);
        return i;
    }

//    /**
//     * @param pageNo
//     * @param pageSize
//     * @return
//     */
//    public List<UserReturn> findPage(Integer pageNo, Integer pageSize) {
//
//        return userMapper.findPage(pageNo, pageSize);
//    }
}
