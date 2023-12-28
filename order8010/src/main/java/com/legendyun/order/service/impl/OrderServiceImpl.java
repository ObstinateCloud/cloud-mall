package com.legendyun.order.service.impl;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.common.entities.Order;
import com.legendyun.order.dao.OrderDao;
import com.legendyun.order.service.OrderService;
import com.legendyun.order.service.feign.AccountFeignService;
import com.legendyun.order.service.feign.StorageFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title: OrderServiceImpl
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/27 11:21
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageFeignService storageFeignService;

    @Resource
    private AccountFeignService accountFeignService;

    @GlobalTransactional
    public int createOrder(Order order) {

        //1. 创建订单 创建
        order.setStatus(0);
       int res1=orderDao.insertOrder(order);
        System.out.println("-----generateId:"+order.getId());
        //2. 减库存
        CommonResult<Integer> res2 = storageFeignService.updateStorageFeign(order.getProductId(), order.getCount());
        //3. 扣余额
        CommonResult<Integer> res3 = accountFeignService.debitAccount(order.getUserId(), order.getCount() * order.getMoney());
        //4. 更改订单状态 完成
//        Order orderNew = orderDao.getOrderById(order.getId());
        int res4 =orderDao.updateOrderStatus(order.getId());
        return res4;
    }
}
