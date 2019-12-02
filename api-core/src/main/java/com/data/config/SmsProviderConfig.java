package com.data.config;

import com.data.sms.SMSProvider;
import com.data.sms.support.ChuangRuiSMSProvider;
import com.data.sms.support.EmaySMSProvider;
import com.data.sms.support.TwoFiveThreeProvider;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  8:31 PM
 * @description:短信配置
 */
@Configuration
public class SmsProviderConfig {
    @Value("${sms.gateway:}")
    private String gateway;
    @Value("${sms.username:}")
    private String username;
    @Value("${sms.password:}")
    private String password;
    @Value("${sms.sign:}")
    private String sign;
    @Value("${sms.internationalGateway:}")
    private String internationalGateway;
    @Value("${sms.internationalUsername:}")
    private String internationalUsername;
    @Value("${sms.internationalPassword:}")
    private String internationalPassword;

    @Bean
    public SMSProvider getSMSProvider(@Value("${sms.driver:}") String driverName) {
        if (StringUtils.isEmpty(driverName)) {
            return new ChuangRuiSMSProvider(gateway, username, password, sign);
        }
        if (driverName.equalsIgnoreCase(ChuangRuiSMSProvider.getName())) {
            return new ChuangRuiSMSProvider(gateway, username, password, sign);
        } else if (driverName.equalsIgnoreCase(EmaySMSProvider.getName())) {
            return new EmaySMSProvider(gateway, username, password);
        } else if (driverName.equalsIgnoreCase(TwoFiveThreeProvider.getName())) {
            return new TwoFiveThreeProvider(gateway, username, password, sign);
        } else {
            return null;
        }
    }
}
