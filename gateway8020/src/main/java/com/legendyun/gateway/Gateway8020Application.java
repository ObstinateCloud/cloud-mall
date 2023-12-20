package com.legendyun.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @title: Gateway8020Application
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/20 16:15
 */

@SpringBootApplication
@EnableEurekaClient
public class Gateway8020Application {

    public static void main(String[] args) {
        SpringApplication.run(Gateway8020Application.class,args);
    }
}
