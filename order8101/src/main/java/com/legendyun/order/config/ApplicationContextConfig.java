package com.legendyun.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @title: ApplicationContextConfig
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 16:46
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
