package com.data.entity;

import java.util.Date;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  2:37 PM
 * @description: 广告表
 */
public class Banner {
    /**
     * ID
     */
    private Integer id;
    /**
     * 广告类型
     */
    private Integer type;
    /**
     * 图片路径
     */
    private String path;
    /**
     * 图片描述
     */
    private String alt;
    /**
     * 跳转路径
     */
    private String url;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 添加IP
     */
    private String addIp;
    /**
     * 标记删除
     */
    private Integer delFlag;
    /**
     * 展示平台
     */
    private Integer shows;

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
     * Gets the value of path.
     *
     * @return the value of path
     */
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the value of alt.
     *
     * @return the value of alt
     */
    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    /**
     * Gets the value of url.
     *
     * @return the value of url
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the value of sort.
     *
     * @return the value of sort
     */
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
     * Gets the value of addIp.
     *
     * @return the value of addIp
     */
    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    /**
     * Gets the value of delFlag.
     *
     * @return the value of delFlag
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * Gets the value of shows.
     *
     * @return the value of shows
     */
    public Integer getShows() {
        return shows;
    }

    public void setShows(Integer shows) {
        this.shows = shows;
    }
}
