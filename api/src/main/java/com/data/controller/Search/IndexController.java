package com.data.controller.Search;

import com.data.controller.BaseController;
import com.data.service.BannerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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


    @ApiOperation(value = "搜索", notes = "搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "trem", value = "内容", required = false, paramType = "query", dataType =
                    "Integer")
    })
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(value = "trem", required = false,
            defaultValue = "1") Integer trem) {
        return null;
    }
}