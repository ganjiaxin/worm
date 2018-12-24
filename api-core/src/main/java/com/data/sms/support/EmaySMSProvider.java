package com.data.sms.support;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  8:25 PM
 * @description:
 */

import com.data.sms.SMSProvider;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : ganjiaxin
 * create at:  2018/12/12  4:33 PM
 * @description:
 */
public class EmaySMSProvider implements SMSProvider {
    public static Log log = LogFactory.getLog(EmaySMSProvider.class);

    private String gateway;
    private String username;
    private String password;

    public EmaySMSProvider(String gateway, String username, String password) {
        this.gateway = gateway;
        this.username = username;
        this.password = password;
    }

    private static Pattern RESPONSE_PATTERN = Pattern.compile("<response><error>(-?\\d+)</error><message>(" +
            ".*[\\\\u4e00-\\\\u9fa5]*)</message></response>");


    public static String getName() {
        return "emay";
    }

    @Override
    public JSONObject sendSingleMessage(String mobile, String content) throws UnirestException {
        log.info("sms content={" + content + "}");
        HttpResponse<String> response = Unirest.post(gateway)
                .field("cdkey", username)
                .field("password", password)
                .field("phone", mobile)
                .field("message", content)
                .asString();
        String resultXml = response.getBody();
        log.info(" mobile : " + mobile + "content : " + content);
        log.info("result = {" + resultXml + "}");
        return parseXml(resultXml);
    }

    public JSONObject sendVerifyMessage(String mobile, String verifyCode) throws Exception {
        String content = formatVerifyCode(verifyCode);
        return sendSingleMessage(mobile, content);
    }

    private JSONObject parseXml(String xml) {
        xml = xml.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
        Matcher matcher = RESPONSE_PATTERN.matcher(xml);
        JSONObject result = new JSONObject();
        if (matcher.find()) {
            result.put("code", matcher.group(1));
            result.put("msg", matcher.group(2));
        }
        return result;
    }
}
