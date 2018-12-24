package com.data.entity;

import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  6:01 PM
 * @description: 用户表
 */
public class User {
    /**
     * ID
     */
    private Integer id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 密钥
     */
    private String salt;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 来源类型
     */
    private Integer source_type;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 添加时间
     */
    private Date add_time;
    /**
     * 添加IP
     */
    private String add_ip;
    /**
     * 推广渠道
     */
    private String channel;
    /**
     * 邀请码
     */
    private String invitation_code;
    /**
     * 用户级别
     */
    private Integer vip;
    /**
     * 用户类型
     */
    private Integer type;
    /**
     * 微信用户标识
     */
    private String wechatOpenid;

    /**
     * Gets the value of id.
     *
     * @return the value of id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the value of nickName.
     *
     * @return the value of nickName
     */
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Gets the value of password.
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the value of salt.
     *
     * @return the value of salt
     */
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * Gets the value of mobile.
     *
     * @return the value of mobile
     */
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the value of userName.
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the value of status.
     *
     * @return the value of status
     */
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Gets the value of email.
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the value of sex.
     *
     * @return the value of sex
     */
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * Gets the value of source_type.
     *
     * @return the value of source_type
     */
    public Integer getSource_type() {
        return source_type;
    }

    public void setSource_type(Integer source_type) {
        this.source_type = source_type;
    }

    /**
     * Gets the value of avatar.
     *
     * @return the value of avatar
     */
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Gets the value of add_time.
     *
     * @return the value of add_time
     */
    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    /**
     * Gets the value of add_ip.
     *
     * @return the value of add_ip
     */
    public String getAdd_ip() {
        return add_ip;
    }

    public void setAdd_ip(String add_ip) {
        this.add_ip = add_ip;
    }

    /**
     * Gets the value of channel.
     *
     * @return the value of channel
     */
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Gets the value of invitation_code.
     *
     * @return the value of invitation_code
     */
    public String getInvitation_code() {
        return invitation_code;
    }

    public void setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
    }

    /**
     * Gets the value of vip.
     *
     * @return the value of vip
     */
    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    /**
     * Gets the value of type.
     *
     * @return the value of type
     */
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Gets the value of wechatOpenid.
     *
     * @return the value of wechatOpenid
     */
    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid;
    }
}
