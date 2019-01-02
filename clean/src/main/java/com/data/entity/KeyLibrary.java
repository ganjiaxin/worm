package com.data.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/21  2:33 PM
 * @description:关键词库
 */
@Table(name = "key_library")
public class KeyLibrary {
    @Column(name = "id")
    private Integer id;
    @Column(name = "key_name")
    private String keyName;
    @Column(name = "fiery")
    private Integer fiery;
    @Column(name = "add_time")
    private Date addTime;
    @Column(name = "update_time")
    private Date updateTime;

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
     * Gets the value of keyName.
     *
     * @return the value of keyName
     */
    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
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
     * Gets the value of fiery.
     *
     * @return the value of fiery
     */
    public Integer getFiery() {
        return fiery;
    }

    public void setFiery(Integer fiery) {
        this.fiery = fiery;
    }

    /**
     * Gets the value of updateTime.
     *
     * @return the value of updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
