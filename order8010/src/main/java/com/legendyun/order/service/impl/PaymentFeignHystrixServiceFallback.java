package com.legendyun.order.service.impl;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.order.service.feign.PaymentFeignHystrixService;
import org.springframework.stereotype.Component;

/**
 * @title: PaymentFeignHystrixServiceFallback
 * @description: 对feignclient接口的全局异常处理 通过实现feign接口重新方法
 * @auther: zhangjianyun
 * @date: 2023/12/11 16:05
 */
@Component
public class PaymentFeignHystrixServiceFallback implements PaymentFeignHystrixService {
    public CommonResult paymentOk(Long id) {

        return new CommonResult(200,"PaymentFeignHystrixServiceFallback.paymentOk");
    }

    public CommonResult paymentTimeout(Long id) {
        return new CommonResult(200,"PaymentFeignHystrixServiceFallback.paymentTimeout");
    }
}
