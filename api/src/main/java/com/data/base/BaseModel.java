package com.data.base;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  5:35 PM
 * @description:
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@ApiModel(value = "基础类Model")
public class BaseModel implements Serializable {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "查询页数")
    private Integer pageNo = 0;

    @ApiModelProperty(value = "查询大小")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "查询条件")
    private String orderBy = "";

    @ApiModelProperty(value = "开始时间")
    private String beginDate;

    @ApiModelProperty(value = "结束时间")
    private String endDate;

    /**** 移动端接口公用参数 ******/
    private String accessToken;
    private String OS;
    private String version;
    private String apiUid;
    private String refreshToken;
    private String channle;
    private String idfa;
    private String mac;
    private String vCode;
    private String device;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo == null ? 1 : pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the value of OS.
     *
     * @return the value of OS
     */
    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    /**
     * Gets the value of accessToken.
     *
     * @return the value of accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Gets the value of version.
     *
     * @return the value of version
     */
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Gets the value of apiUid.
     *
     * @return the value of apiUid
     */
    public String getApiUid() {
        return apiUid;
    }

    public void setApiUid(String apiUid) {
        this.apiUid = apiUid;
    }

    /**
     * Gets the value of refreshToken.
     *
     * @return the value of refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Gets the value of channle.
     *
     * @return the value of channle
     */
    public String getChannle() {
        return channle;
    }

    public void setChannle(String channle) {
        this.channle = channle;
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
     * Gets the value of vCode.
     *
     * @return the value of vCode
     */
    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    /**
     * Gets the value of device.
     *
     * @return the value of device
     */
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
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
}
