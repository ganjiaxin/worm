package com.data.controller.Home;

import com.data.entity.Banner;
import com.data.service.BannerService;
import com.data.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  3:08 PM
 * @description:
 */
@RestController
public class BannerController {

    @Autowired
    BannerService bannerService;

    @RequestMapping("/selectBannerByTypeAndShows")
    public String selectBannerByTypeAndShows(Integer type, String shows) {
        List<Banner> list = bannerService.selectBannerByTypeAndShows(type, shows);
        return JsonUtils.getJSONArrayFromList(list);
    }
}
