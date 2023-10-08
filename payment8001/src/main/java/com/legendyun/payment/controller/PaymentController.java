package com.legendyun.payment.controller;

import com.legendyun.payment.entities.CommonResult;
import com.legendyun.payment.entities.Payment;
import com.legendyun.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @title: PaymentController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:35
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "create")
    public CommonResult createPayment(Payment payment){
        int result = paymentService.createPayment(payment);
        log.info(" insert success");
        if (result>0){
            return new CommonResult(200,"success",result);
        }else {
            return new CommonResult(201,"insert error");
        }
    }

    @GetMapping(value = "get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("123");
        if(payment!=null){
            return new CommonResult(200,"success",payment);
        }else {
            return new CommonResult(201,"not found");
        }


    }
}
