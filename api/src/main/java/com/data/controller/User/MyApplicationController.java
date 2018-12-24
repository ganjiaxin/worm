package com.data.controller.User;

import com.data.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ganjiaxin
 * create at:  2018/12/20  12:38 PM
 * @description:
 */
@RestController
@RequestMapping("/user")
@Api(value = "我的应用", description = "我的应用")
public class MyApplicationController extends BaseController {
}
