package com.legendyun.payment.service;

/**
 * @title: AccountService
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/27 11:18
 */
public interface AccountService {
    int debitAccount(Integer userId, Integer cost);
}
