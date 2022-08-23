package com.mio.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: MyBatis配置类
 * @author: miosakura
 * @date: 2022-08-22 15:20
 */
@Configuration
@MapperScan("com.mio.mall.mbg.mapper")
public class MyBatisConfig {
}
