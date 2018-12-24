package com.data.interceptor;

import com.data.config.RedisUtil;
import com.data.config.SystemParamsUtil;
import com.data.ret.Msg;
import com.data.service.UserService;
import com.data.utils.CommonUtil;
import com.data.utils.IdGen;
import com.data.utils.JsonUtils;
import com.data.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  2:21 PM
 * @description:
 */
public class ApiInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(ApiInterceptor.class);

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Msg msg = new Msg();
        log(request);
        logger.info("URL PARAM---------------------------------------------------------");
        logger.info(JsonUtils.toJSONString(request.getParameterMap()));
        logger.info(request.getServletPath());


        if (isStaticPath(request)) {
            return true;
        }
        // 只要包含指定接口名就可过滤
        List<Object> apiList = SystemParamsUtil.initStartUp();
        // 只要包含指定接口名就可过滤
        if (!apiList.contains(request.getServletPath().substring(request.getServletPath().lastIndexOf("/"),
                request.getServletPath().length()))) {
            String uid = request.getParameter("apiUid");
            if (StringUtils.isNotEmpty(request.getParameter("accessToken")) && StringUtils.isNotEmpty(uid)) {
                Object obj = redisUtil.get(uid);
                if (obj == null) {
                    // 没有此用户的缓存
                    msg.setCode("-101");
                    close(msg, response);
                    return false;
                } else {
                    Map<String, Object> objMap = (Map<String, Object>) obj;
                    String accessToken = (String) redisUtil.get(objMap.get("accessToken").toString());
                    if (accessToken == null) {
                        //账户状态已过期，请重新登陆
                        msg.setCode("-101");
                        close(msg, response);
                        return false;
                    }
                }
                JSONObject jsonObject = JSONObject.fromObject(userService.findByKey(Integer.valueOf(uid)));
                if (jsonObject == null) {
                    // 找不到此用户
                    msg.setCode("-1038");
                    close(msg, response);
                    return false;
                }
                System.out.println(request.getRemoteAddr() + request.getSession().getId());
            } else {
                msg.setCode("-100");
                close(msg, response);
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }

    private void log(HttpServletRequest request) {
        String ip = CommonUtil.getIp(request);
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getRequestURI();
        String referer = request.getHeader("referer");
        String userAgent = request.getHeader("user-agent");
        String clientCode = request.getParameter("accesstoken");

        logger.info("请求ip：" + ip + " 请求url：" + url + " referer：" + referer + " userAgent：" + userAgent + " clientCode:"
                + clientCode);
    }

    public void close(Msg ret, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ret);
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }

    private boolean isStaticPath(HttpServletRequest request) {
        if (request.getRequestURI().contains(".js") || request.getRequestURI().contains(".html")
                || request.getRequestURI().contains(".css") || request.getRequestURI().contains(".png")
                || request.getRequestURI().contains(".jpg") || request.getRequestURI().contains(".gif")
                || request.getRequestURI().contains(".htm") || request.getRequestURI().contains(".swf")
                || request.getRequestURI().contains(".ico") || request.getRequestURI().equals("/")
                || !request.getRequestURI().contains(".")) {
            return true;
        }
        return false;
    }
}
