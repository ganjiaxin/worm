package com.data.sms.support;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  8:21 PM
 * @description:
 */

import com.data.sms.SMSProvider;
import com.data.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

/**
 * @author : ganjiaxin
 * create at:  2018/12/12  4:46 PM
 * @description:
 */
public class TwoFiveThreeProvider implements SMSProvider {
    public static Log log = LogFactory.getLog(TwoFiveThreeProvider.class);

    private String gateway;
    private String username;
    private String password;
    private String sign;

    public TwoFiveThreeProvider(String gateway, String username, String password, String sign) {
        this.gateway = gateway;
        this.username = username;
        this.password = password;
        this.sign = sign;
    }

    public static String getName() {
        return "two_five_three";
    }

    @Override
    public JSONObject sendSingleMessage(String mobile, String content) throws Exception {
        log.info("sms content={" + content + "}");
        //请求地址
        String url = this.gateway;
        //API账号，50位以内。必填
        String account = this.username;
        //API账号对应密钥，联系客服获取。必填
        String password = this.password;
        //短信内容。长度不能超过536个字符。必填
        String msg = "【" + this.sign + "】" + content;
        //组装请求参数
        JSONObject map = new JSONObject();
        map.put("account", account);
        map.put("password", password);
        map.put("msg", msg);
        map.put("mobile", mobile);
        String params = map.toString();
        log.info("请求参数为:" + params);
        HttpResponse<String> response = Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(params)
                .asString();
        log.info("返回参数为:" + response);
        JSONObject jsonObject = JsonUtils.stringtoJson(response.getBody());
        String code = jsonObject.get("code").toString();
        String msgid = jsonObject.get("msgid").toString();
        String error = jsonObject.get("error").toString();
        log.info("状态码:" + code + ",状态码说明:" + error + ",消息id:" + msgid);
        return jsonObject;
    }
}
