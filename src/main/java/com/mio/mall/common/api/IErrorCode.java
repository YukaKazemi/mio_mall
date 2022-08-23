package com.mio.mall.common.api;

/**
 * @description: 常用API返回对象接口
 * @author: miosakura
 * @date: 2022-08-22 16:38
 */
public interface IErrorCode {
    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}
