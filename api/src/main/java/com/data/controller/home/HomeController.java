package com.data.controller.home;

import com.data.service.BannerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ganjiaxin
 * create at:  2018/12/19  2:24 PM
 * @description:
 */
@RestController
public class HomeController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation(value = "获取广告页", notes = "获取广告页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", required = false, paramType = "query", dataType =
                    "Integer")
    })
    @ResponseBody
    @RequestMapping(value = "/getBanner", method = RequestMethod.GET)
    public String getBanner(@RequestParam(value = "type", required = false, defaultValue = "1") Integer type) {
        return bannerService.selectBannerByTypeAndShows(1, null);
    }


}
