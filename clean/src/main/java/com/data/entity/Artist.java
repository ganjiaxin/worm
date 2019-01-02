package com.data.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/27  2:09 PM
 * @description:发行商
 */
@Table(name = "artist")
public class Artist {
    @Column(name = "id")
    private Integer id;
    @Column(name = "artist_id")
    private Integer artistId;
    @Column(name = "name")
    private String name;
    @Column(name = "view_url")
    private String viewUrl;
    @Column(name = "add_time")
    private Date addTime;

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
     * Gets the value of artistId.
     *
     * @return the value of artistId
     */
    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    /**
     * Gets the value of name.
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of viewUrl.
     *
     * @return the value of viewUrl
     */
    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
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
}
