package com.legendyun.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @title: Payment8001
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:01
 */

@SpringBootApplication
@EnableEurekaClient  //eureka 专用
//@EnableDiscoveryClient //eureka zookeeper consoul nacoe通用服务注册发现
public class Payment8001 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8001.class,args);
    }
}
