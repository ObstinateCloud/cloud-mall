package com.legendyun.order.controller;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.common.entities.Payment;
import com.legendyun.order.mylb.ZjyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;


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

    @Resource
    private ZjyLoadBalancer zjyLoadBalancer;

    //服务发现配置
    @Resource
    private DiscoveryClient discoveryClient;

    public static final String PAYMENT_URL="http://payment8001";
//    public static final String PAYMENT_URL="http://localhost:8001";  //初代版本

    @PostMapping("create")
    public CommonResult<Payment> createOrder(Payment payment){


        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    /**
     * getForObject 返回值为json
     * @param id
     * @return
     */

    @GetMapping("get/paymentObj/{id}")
    public CommonResult<Payment> getOrderPaymentForObj(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    /**
     * 返回值为请求对象 包含更多请求信息
     * @param id
     * @return
     */
    @GetMapping("get/paymentEntity/{id}")
    public CommonResult<Payment> getOrderPaymentForEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> resultResponseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        log.info(resultResponseEntity.getStatusCode().toString());
        log.info(resultResponseEntity.getHeaders().toSingleValueMap().toString());
        return resultResponseEntity.getBody();
    }

    @PostMapping("create/paymentEntity")
    public CommonResult<Payment> createOrderEntity(Payment payment){
        ResponseEntity<CommonResult> resultResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        log.info(resultResponseEntity.getStatusCode().toString());
        log.info(resultResponseEntity.getHeaders().toSingleValueMap().toString());
        return resultResponseEntity.getBody();
    }

    /**
     * 使用自定的负载
     * @param id
     * @return
     */
    @GetMapping("get/paymentEntity/mylb/{id}")
    public CommonResult<Payment> getOrderPaymentMyLbForEntity(@PathVariable("id") Long id) throws Exception {


        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("payment8001");
        if (serviceInstances ==null || serviceInstances.size()<=0){
            throw new Exception("service not found");
        }

        ServiceInstance instances = zjyLoadBalancer.instances(serviceInstances);

        ResponseEntity<CommonResult> resultResponseEntity = restTemplate.getForEntity( instances.getUri()+ "/payment/get/" + id, CommonResult.class);
        log.info(resultResponseEntity.getStatusCode().toString());
        log.info(resultResponseEntity.getHeaders().toSingleValueMap().toString());
        return resultResponseEntity.getBody();
    }

}
