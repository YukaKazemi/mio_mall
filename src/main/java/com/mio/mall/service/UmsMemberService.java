package com.mio.mall.service;

import com.mio.mall.common.api.CommonResult;

/**
 * @description: 会员管理Service
 * @author: miosakura
 * @date: 2022-08-23 11:17
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
