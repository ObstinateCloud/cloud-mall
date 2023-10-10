package com.legendyun.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @title: EurekaMain7001
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/10 15:20
 */

@SpringBootApplication
@EnableEurekaServer //标记为服务端
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
