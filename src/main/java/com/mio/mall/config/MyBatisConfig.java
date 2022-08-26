package com.mio.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"com.mio.mall.dao","com.mio.mall.mbg.mapper"})
public class MyBatisConfig {
}
