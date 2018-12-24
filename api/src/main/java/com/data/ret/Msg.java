package com.data.ret;

import com.data.utils.MessageUtil;
import com.data.utils.StringUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : ganjiaxin
 * create at:  2018/12/10  12:24 PM
 * @description:
 */
@ApiModel(value = " 返回类")
public class Msg<Object> {
    @ApiModelProperty(value = "CODE")
    private String code;
    @ApiModelProperty(value = "描述")
    private String msg;
    @ApiModelProperty(value = "对象")
    private Object data;




    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        if (StringUtils.isNotBlank(msg)) {
            return MessageUtil.getMessage(this.getCode()) + "," + msg;
        }
        return MessageUtil.getMessage(this.getCode());
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



    public Msg() {
        // TODO Auto-generated constructor stub
    }

    public Msg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
