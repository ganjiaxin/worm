package com.data.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/21  10:44 AM
 * @description:关键词关系
 */
@Table(name = "key_word")
public class KeyWord {
    @Column(name = "id")
    private Integer id;
    @Column(name = "key_name")
    private String keyName;
    @Column(name = "track_id")
    private Integer trackId;
    @Column(name = "ranking")
    private Integer ranking;
    @Column(name = "region")
    private String region;
    @Column(name = "add_time")
    private Date addTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "key_id")
    private Integer keyId;
    @Column(name = "state")
    private Integer state;

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
     * Gets the value of trackId.
     *
     * @return the value of trackId
     */
    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    /**
     * Gets the value of ranking.
     *
     * @return the value of ranking
     */
    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    /**
     * Gets the value of region.
     *
     * @return the value of region
     */
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    /**
     * Gets the value of keyId.
     *
     * @return the value of keyId
     */
    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    /**
     * Gets the value of state.
     *
     * @return the value of state
     */
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
