package com.legendyun.order.controller;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.order.service.feign.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @title: OrderPaymentController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/25 13:55
 */

@RestController
@RequestMapping("paymentFeign")
@Slf4j
public class OrderPaymentController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("getPaymentByIdFeign/{id}")
    private CommonResult getPaymentByIdFeign(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentByIdFeign(id);
    }


    @GetMapping("mockTimeout")
    private String mockTimeout(){
        //openfeign 默认超时时间1s
        return paymentFeignService.feignTimeout();
    }

}
