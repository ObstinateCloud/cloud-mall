package com.legendyun.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @title: StorageApplication
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/27 10:22
 */

@SpringBootApplication
@EnableDiscoveryClient //eureka zookeeper consoul nacoe通用服务注册发现
//@EnableCircuitBreaker
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class,args);
    }
}
