package com.data.entity;

import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  7:47 PM
 * @description:用户登陆信息表
 */
public class LoginLog {

    /**
     * ID
     */
    private Integer id;
    /**
     * 登陆设备
     */
    private String loginDevice;
    /**
     * 登陆IP
     */
    private String loginIp;
    /**
     * 登陆时间
     */
    private Date loginTime;
    /**
     * 用户主键
     */
    private String uid;
    /**
     * MAC地址
     */
    private String mac;
    /**
     * IDFA地址
     */
    private String idfa;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

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
     * Gets the value of loginDevice.
     *
     * @return the value of loginDevice
     */
    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }

    /**
     * Gets the value of loginIp.
     *
     * @return the value of loginIp
     */
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * Gets the value of loginTime.
     *
     * @return the value of loginTime
     */
    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * Gets the value of uid.
     *
     * @return the value of uid
     */
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Gets the value of mac.
     *
     * @return the value of mac
     */
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * Gets the value of idfa.
     *
     * @return the value of idfa
     */
    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
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
     * Gets the value of remark.
     *
     * @return the value of remark
     */
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
