package com.data.entity;

import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  8:09 PM
 * @description:用户邀请信息表
 */
public class InvitetionUser {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 受邀者ID
     */
    private Integer inviteeId;
    /**
     * 邀请时间
     */
    private Date addTime;
    /**
     * 状态
     */
    private String state;

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
     * Gets the value of userId.
     *
     * @return the value of userId
     */
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the value of inviteeId.
     *
     * @return the value of inviteeId
     */
    public Integer getInviteeId() {
        return inviteeId;
    }

    public void setInviteeId(Integer inviteeId) {
        this.inviteeId = inviteeId;
    }

    /**
     * Gets the value of addTime.
     *
     * @return the value of addTime
     */
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * Gets the value of state.
     *
     * @return the value of state
     */
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
