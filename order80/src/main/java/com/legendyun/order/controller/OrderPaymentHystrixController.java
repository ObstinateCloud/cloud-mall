package com.legendyun.order.controller;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.order.service.feign.PaymentFeignHystrixService;
import com.legendyun.order.service.feign.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @title: OrderPaymentController
 * @description: 带服务降级的处理
 * @auther: zhangjianyun
 * @date: 2023/10/25 13:55
 */

@RestController
@RequestMapping("paymentFeignHystrix")
@Slf4j
public class OrderPaymentHystrixController {


    @Autowired
    private PaymentFeignHystrixService paymentFeignHystrixService;


    @GetMapping(value = "paymentOkHystrix/{id}")
    private CommonResult paymentOkHystrix(@PathVariable("id") Long id){
        return paymentFeignHystrixService.paymentOk(id);
    }

    @GetMapping(value = "paymentTimeoutHystrix/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeoutHystrixHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "500")}) //@HystrixCommand 注解的方法不能使用private修饰
    public CommonResult paymentTimeoutHystrix(@PathVariable("id") Long id){
        CommonResult commonResult = paymentFeignHystrixService.paymentTimeout(id);
        System.out.println(commonResult.getData());
//        int age = 10/0;
        return commonResult;
    }

    private CommonResult  paymentTimeoutHystrixHandler(@PathVariable("id") Long id){
        return new CommonResult(200,"调用支付接口超时或订单服务异常");
    }
}
