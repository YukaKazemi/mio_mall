package com.mio.mall.controller;

import com.mio.mall.common.api.CommonResult;
import com.mio.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: 会员登录注册管理Controller
 * @author: miosakura
 * @date: 2022-08-23 12:51
 */
@Controller
@Api(tags = "UmsMemberController",description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {
        @Autowired
        private UmsMemberService umsMemberService;
        @ApiOperation("获取验证码")
        @RequestMapping(value = "/getAuthCode",method = RequestMethod.GET)
        @ResponseBody
        public CommonResult getAuthCode(@RequestParam String telephone){
            return umsMemberService.generateAuthCode(telephone);
        }
       @ApiOperation("判断验证码是否正确")
       @RequestMapping(value = "/verifyAuthCode",method = RequestMethod.GET)
       @ResponseBody
        public CommonResult updatePassword(@RequestParam String telephone,@RequestParam String authCode ){
                return umsMemberService.verifyAuthCode(telephone, authCode);
        }

}
