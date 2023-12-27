package com.legendyun.payment;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @title: Payment8001
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:01
 */

@SpringBootApplication
//@EnableEurekaClient  //eureka 专用
@EnableDiscoveryClient //eureka zookeeper consoul nacoe通用服务注册发现
//@EnableCircuitBreaker //开启服务降级
public class Payment8001 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8001.class,args);
    }

    // 否则hystrix-dashboard 会报Unable to connect to Command Metric Stream.的异常
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
}
