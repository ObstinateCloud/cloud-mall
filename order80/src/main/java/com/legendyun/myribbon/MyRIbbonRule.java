package com.legendyun.myribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: MyRIbbonRule
 * @description: TODO 自定义负载均衡规则 自定义规则必须不能再application 类及其下级类中
 * @auther: zhangjianyun
 * @date: 2023/10/24 16:57
 */

@Configuration
public class MyRIbbonRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//自定义为随机访问
    }
}
