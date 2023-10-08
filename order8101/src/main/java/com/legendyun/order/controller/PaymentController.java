package com.legendyun.order.controller;

import com.legendyun.order.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @title: PaymentController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:35
 */
@RestController
@RequestMapping("order")
@Slf4j
public class PaymentController {
    @Resource
    private RestTemplate restTemplate;

    public CommonResult createOrder(){
        return new CommonResult(200,"success");
    }

}
