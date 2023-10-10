package com.legendyun.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @title: Order80
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:01
 */

@SpringBootApplication
@EnableEurekaClient
public class Order80 {

    public static void main(String[] args) {
        SpringApplication.run(Order80.class,args);
    }
}
