package com.legendyun.payment.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.legendyun.common.entities.CommonResult;
import com.legendyun.payment.handle.CustomSentinelBlockHandler;
import com.legendyun.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @title: PaymentSentinelController
 * @description: 基于sentinel 的自定义限流处理方法
 * @auther: zhangjianyun
 * @date: 2023/11/2 16:03
 */

@RestController
@RequestMapping("paymentSentinel")
public class PaymentSentinelController {


    //流控规则 //SentinelResource 无法处理运行时异常
    //热点规则 可以对请求中的某个参数进行限流

    @GetMapping("hotKey")
    @SentinelResource(value = "hotKeySentinel",blockHandler = "hotKeySentinel_Handler") //paymentOkSentinel 资源名要求唯一
    public CommonResult paymentOk(@RequestParam(value = "p1",required = false)String p1, @RequestParam(value = "p2",required = false)String p2){
//        int a = 10/0;
        long timeStart = System.currentTimeMillis();
        System.out.println("hotKeySentinel");
        long timeEnd = System.currentTimeMillis();
        String res = "线程池:"+Thread.currentThread().getName()+",p1="+p1+",p2="+p2+" ，耗时："+(timeEnd-timeStart)+"ms";
        CommonResult commonResult = new CommonResult(200,res);
        return commonResult;
    }

    public CommonResult hotKeySentinel_Handler(String p1, String p2, BlockException exception){ //BlockException 这个必须要加否则无法进入这个方法 会返回默认的错误页面
        System.out.println("sentinel热点限流");
        return new CommonResult<>(201,"线程池:+Thread.currentThread().getName()"+",p1="+p1+",p2="+p2+",sentinel热点限流，调用超时了请稍后再试");
    }

    //自定义流控
    @GetMapping("customException")
    @SentinelResource(value = "customException",blockHandlerClass = {CustomSentinelBlockHandler.class},blockHandler = "handlerException1") //paymentOkSentinel 资源名要求唯一
    public CommonResult customException(){
//        int a = 10/0;  //SentinelResource 无法处理运行时异常
        long timeStart = System.currentTimeMillis();
        System.out.println("customException");
        long timeEnd = System.currentTimeMillis();
        String res = "线程池:"+Thread.currentThread().getName()+" ，耗时："+(timeEnd-timeStart)+"ms";
        CommonResult commonResult = new CommonResult(200,res);
        return commonResult;
    }

    //熔断规则 可以处理系统发生的业务异常 blockHandler与fallback同时存在时 优先被blockHandler拦截
    //exceptionsToIgnore 忽略某些异常类型

    @GetMapping("fallBack")
    @SentinelResource(value = "fallBack",fallback = "fallBack_Handler",exceptionsToIgnore = {IllegalArgumentException.class}) //blockHandler与控制台对应，
    public CommonResult fallBack(@RequestParam(value = "p1",required = false)String p1, @RequestParam(value = "p2",required = false)String p2){
        System.out.println("hotKeySentinel");
        if (p1.equals("aa")){
            throw new IllegalArgumentException("p1参数异常");
        }
        if (p2.equals("bb")){
            int a = 10/0;
        }
        String res = "fallBack测试，线程池:"+Thread.currentThread().getName()+",p1="+p1+",p2="+p2;
        CommonResult commonResult = new CommonResult(200,res);
        return commonResult;
    }

    public CommonResult fallBack_Handler(String p1, String p2, Throwable exception){ //BlockException 这个必须要加否则无法进入这个方法 会返回默认的错误页面
        System.out.println("sentinel  熔断处理");
        return new CommonResult<>(201,"fallBack触发"+",p1="+p1+",p2="+p2+",sentinel熔断，请稍后再试"+exception.getMessage());
    }


}
