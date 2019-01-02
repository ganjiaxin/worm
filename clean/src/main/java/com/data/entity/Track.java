package com.data.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/22  12:30 PM
 * @description: 应用表
 */
@Table(name = "track")
public class Track {
    @Column(name = "id")
    private Integer id;
    @Column(name = "track_id")
    private Integer trackId;
    @Column(name = "name")
    private String name;
    @Column(name = "content_rating")
    private String contentRating;
    @Column(name = "view_url")
    private String viewUrl;
    @Column(name = "censored_name")
    private String censoredName;
    @Column(name = "artist_id")
    private Integer artistId;
    @Column(name = "primary_genre_id")
    private Integer primaryGenreId;
    @Column(name = "primary_genre_name")
    private String primaryGenreName;
    @Column(name = "kind")
    private String kind;
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
     * Gets the value of contentRating.
     *
     * @return the value of contentRating
     */
    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
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
     * Gets the value of censoredName.
     *
     * @return the value of censoredName
     */
    public String getCensoredName() {
        return censoredName;
    }

    public void setCensoredName(String censoredName) {
        this.censoredName = censoredName;
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
     * Gets the value of primaryGenreName.
     *
     * @return the value of primaryGenreName
     */
    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    /**
     * Gets the value of kind.
     *
     * @return the value of kind
     */
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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
     * Gets the value of primaryGenreId.
     *
     * @return the value of primaryGenreId
     */
    public Integer getPrimaryGenreId() {
        return primaryGenreId;
    }

    public void setPrimaryGenreId(Integer primaryGenreId) {
        this.primaryGenreId = primaryGenreId;
    }
}

