package com.data.controller.User;

import com.data.base.BaseModel;
import com.data.controller.BaseController;
import com.data.ret.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONException;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ganjiaxin
 * create at:  2018/12/20  12:39 PM
 * @description:
 */
@RestController
@RequestMapping("/user")
@Api(value = "我的关键字", description = "我的关键字")
public class MyKeyController extends BaseController {


    @CrossOrigin
    @ApiOperation(value = "我的关键字")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "userName", value = "用户名", required = false, paramType = "query", dataType =
                    "String"), @ApiImplicitParam(name = "password", value = "密码", required = false, paramType = "query",
                    dataType = "String")
            }
    )
    @ResponseBody
    @RequestMapping(value = "/myKey", method = RequestMethod.POST)
    public Msg myKey(BaseModel model) {


        return null;
    }


}
