package com.legendyun.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: GateWayConfig
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/21 10:00
 */

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("news", r -> r.path("/news").uri("https://news.baidu.com/"));
        routes.route("tieba", r -> r.path("/tieba").uri("https://tieba.baidu.com/"));
        routes.route("image", r -> r.path("/image").uri("https://image.baidu.com/"));

        return routes.build();
    }
}
