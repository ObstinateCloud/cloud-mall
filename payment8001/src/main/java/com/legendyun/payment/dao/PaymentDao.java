package com.legendyun.payment.dao;

import com.legendyun.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import javax.websocket.server.PathParam;

/**
 * @title: PaymentDao
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:14
 */

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@PathParam("id") Long id);
}
