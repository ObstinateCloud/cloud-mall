package com.legendyun.payment.dao;

import com.legendyun.common.entities.Account;
import org.apache.ibatis.annotations.Mapper;


/**
 * @title: PaymentDao
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:14
 */

@Mapper
public interface AccountDao {


    Account getAccountByUserId(Integer userId);

    int debitAccount(Account accountOld);
}
