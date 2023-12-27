package com.legendyun.order.controller;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.common.entities.Order;
import com.legendyun.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @title: OrderController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/27 11:24
 */

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("createOrder")
    public CommonResult createOrder(@RequestBody Order order) {

        int result = orderService.createOrder(order);
        CommonResult commonResult = null;
        if (result == 1) {
            commonResult = new CommonResult(200, "创建订单成功");
        }else {
            commonResult = new CommonResult(201, "创建订单失败");
        }
        return commonResult;
    }
}
