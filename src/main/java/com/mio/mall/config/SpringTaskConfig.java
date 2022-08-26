package com.mio.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description: 定时任务配置
 * 只需要在配置类中添加一个@EnableScheduling注解即可开启SpringTask的定时任务能力
 * @author: miosakura
 * @date: 2022-08-26 12:02
 */
@Configuration
@EnableScheduling
public class SpringTaskConfig {

}
