package com.legendyun.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @title: Gateway8020Application
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/20 16:15
 */

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class Gateway8020Application {

    public static void main(String[] args) {
        SpringApplication.run(Gateway8020Application.class,args);
    }
}
