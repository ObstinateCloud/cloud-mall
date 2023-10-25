package com.legendyun.payment.controller;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.common.entities.Payment;
import com.legendyun.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}")
    private Integer serverPort;

    //服务发现配置
    @Resource
    private DiscoveryClient discoveryClient;

  @PostMapping(value = "create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment){  //此处不加RequestBody，跨项目调用无法接受参数
        int result = paymentService.createPayment(payment);
        log.info(" insert success "+ serverPort);

        if (result>0){
            return new CommonResult(200,"success",result);
        }else {
            return new CommonResult(201,"insert error");
        }
    }

    @GetMapping(value = "get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info(" search success "+ serverPort);
        if(payment!=null){
            return new CommonResult(200,"success",payment);
        }else {
            return new CommonResult(201,"not found");
        }
    }

    /**
     * 获取注册的服务信息
     * @return
     */
    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(p->{
            log.info("element:"+p);
        });

        List<ServiceInstance> payment8001 = discoveryClient.getInstances("payment8001");
        payment8001.forEach(p->{
            log.info(p.getServiceId()+" "+p.getHost()+" "+ p.getUri()+" "+p.getPort());
        });
        return discoveryClient;

    }

    /**
     * 模拟超时接口
     * @return
     */
    @GetMapping(value = "feign/timeout")
    public String feignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "invoke sucess:"+new Date().toString();
    }
}
