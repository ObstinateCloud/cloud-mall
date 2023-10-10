package com.legendyun.order.controller;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @title: OrderController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:35
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL="http://payment8001";
//    public static final String PAYMENT_URL="http://localhost:8001";  //初代版本

    @PostMapping("create")
    public CommonResult<Payment> createOrder(Payment payment){


        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("get/payment/{id}")
    public CommonResult<Payment> getOrderPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}
