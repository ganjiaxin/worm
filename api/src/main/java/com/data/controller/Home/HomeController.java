package com.data.controller.Home;

import com.data.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  2:24 PM
 * @description:
 */
@RestController
public class HomeController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/getBanner", method = RequestMethod.GET)
    public String getBanner(@RequestParam(value = "type", required = false, defaultValue = "1") Integer type) {
        return bannerService.selectBannerByTypeAndShows(1, null);
    }


}
