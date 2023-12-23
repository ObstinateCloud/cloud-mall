package com.legendyun.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RefreshScope //只能加在bean上否则无法自动刷新
public class NacosConfigController {

    @Value("${mainInfo}")
    private String mainInfo;

    @Value("${extInfo}")
    private String extInfo;

    @Value("${shareInfo}")
    private String shareInfo;

    @GetMapping("getNacosInfo")
    public String getZjyInfo(){
        return "main:"+mainInfo+",share:"+shareInfo+",ext:"+extInfo;
    }


}
