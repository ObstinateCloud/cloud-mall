package com.legendyun.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @title: MyLogGolbalFilter
 * @description: 自定义全局过滤器
 * @auther: zhangjianyun
 * @date: 2023/12/21 11:47
 */

@Component
public class MyLogGolbalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("------coming MyLogGolbalFilter----"+new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname ==null){
            System.out.println("-----用户名为空---");
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //数字越小 优先级越高
        return 0;
    }
}
