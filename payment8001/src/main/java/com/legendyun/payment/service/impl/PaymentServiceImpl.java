package com.legendyun.payment.service.impl;

import com.legendyun.payment.dao.PaymentDao;
import com.legendyun.payment.entities.Payment;
import com.legendyun.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title: PaymentServiceImpl
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:32
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    public int createPayment(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
