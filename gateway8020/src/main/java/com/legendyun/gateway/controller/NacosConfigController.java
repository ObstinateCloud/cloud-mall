package com.legendyun.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NacosConfigController {

    @Value("${zjyinfo}")
    private String info;

    @GetMapping("getNacosInfo")
    public String getZjyInfo(){
        return info;
    }
}
