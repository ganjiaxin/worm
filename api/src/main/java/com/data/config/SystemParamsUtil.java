package com.data.config;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  5:44 PM
 * @description:
 */
@Component
public class SystemParamsUtil {
    // API权限
    public static List<Object> apiList = new ArrayList<Object>();
    public static PrivilegeConfig configPrivilege = new PrivilegeConfig();

    @SuppressWarnings("unchecked")
    public static List initStartUp() {
        apiList = configPrivilege.PrivilegeConfig("url");
        return apiList;
    }
}
