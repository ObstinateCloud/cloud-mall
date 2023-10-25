package com.legendyun.order;

import com.legendyun.myribbon.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @title: Order80
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:01
 */

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "payment8001",configuration = MyRibbonRule.class) //payment8001要调用的服务名称
//@RibbonClients //全局生效 不同服务自定策略需要比较麻烦
@EnableFeignClients
public class Order80 {

    public static void main(String[] args) {
        SpringApplication.run(Order80.class,args);
    }
}
