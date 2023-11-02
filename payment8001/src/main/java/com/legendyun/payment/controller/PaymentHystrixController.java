package com.legendyun.payment.controller;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @title: PaymentHystrixController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/11/2 16:03
 */

@RestController
@RequestMapping("paymentHystrix")
public class PaymentHystrixController {

    @Resource
    private PaymentService paymentService;
    @GetMapping("paymentOk/{id}")
    private CommonResult paymentOk(@PathVariable("id")Integer id){

        long timeStart = System.currentTimeMillis();
        System.out.println("paymentOk");
        long timeEnd = System.currentTimeMillis();
        String res = "线程池:"+Thread.currentThread().getName()+",id="+id+" ，耗时："+(timeEnd-timeStart)+"ms";
        CommonResult commonResult = new CommonResult(200,res);
        return commonResult;
    }
    @GetMapping("paymentTimeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    }) //超时2秒自动进入异常处理方法
    public CommonResult paymentTimeout(@PathVariable("id")Integer id){
            long timeStart = System.currentTimeMillis();
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        long timeEnd = System.currentTimeMillis();
        return new CommonResult<>(200,"线程池:"+Thread.currentThread().getName()+",id="+id+" ，耗时："+(timeEnd-timeStart)+"ms");
    }

    public CommonResult paymentTimeoutHandler(Integer id){
        System.out.println("服务降级测试");
        return new CommonResult<>(201,"线程池:+Thread.currentThread().getName()"+"id=:"+id+",服务降级测试，调用超时了请稍后再试");
    }
}
