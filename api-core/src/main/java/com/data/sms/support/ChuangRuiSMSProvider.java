package com.data.sms.support;

import com.data.sms.SMSProvider;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 创瑞短信接口实现类
 */
public class ChuangRuiSMSProvider implements SMSProvider {
    public static Log log = LogFactory.getLog(ChuangRuiSMSProvider.class);

    private String gateway;
    private String username;
    private String password;
    private String sign;

    public ChuangRuiSMSProvider(String gateway, String username, String password, String sign) {
        this.gateway = gateway;
        this.username = username;
        this.password = password;
        this.sign = sign;
    }

    public static String getName() {
        return "chuangrui";
    }

    @Override
    public JSONObject sendSingleMessage(String mobile, String content) throws Exception {
        log.info("sms content={" + content + "}");
        HttpResponse<String> response = Unirest.post(gateway)
                .field("name", username)
                .field("pwd", password)
                .field("mobile", mobile)
                .field("content", content + "【" + sign + "】")
                .field("time", "")
                .field("type", "pt")
                .field("extno", "")
                .asString();
        log.info(" mobile : " + mobile + "content : " + content);
        log.info("result = {" + response.getBody() + "}");
        return parseResult(response.getBody());
    }

    private JSONObject parseResult(String result) {
        //返回示例：0,2017110112134171782680251,0,1,0,提交成功
        String[] parts = result.split(",");
        JSONObject mr = new JSONObject();
        mr.put("code", parts[0]);
        mr.put("msg", parts[1]);
        return mr;
    }
}
