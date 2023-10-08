package com.legendyun.payment.service;

import com.legendyun.payment.entities.Payment;

/**
 * @title: PaymentService
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:31
 */
public interface PaymentService {

    int createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
