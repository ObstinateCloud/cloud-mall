package com.legendyun.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: FeignConfig
 * @description: OpenFeign 日志增强
 * @auther: zhangjianyun
 * @date: 2023/10/25 14:53
 */

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
