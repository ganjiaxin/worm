package com.data.controller.User;

import com.data.controller.BaseController;
import com.data.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : ganjiaxin
 * create at:  2018/12/20  12:38 PM
 * @description:
 */
public class IndexController extends BaseController {



    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getBanner(@RequestParam(value = "trem", required = false,
            defaultValue = "1") Integer type) {
        return null;
    }
}