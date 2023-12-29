package com.legendyun.payment.service.impl;

import com.legendyun.common.entities.Account;
import com.legendyun.common.entities.Storage;
import com.legendyun.payment.dao.AccountDao;
import com.legendyun.payment.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title: AccountServiceImpl
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/27 11:18
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public int debitAccount(Integer userId, Integer cost) {

        Account accountOld = accountDao.getAccountByUserId(userId);

        if (accountOld !=null){
            if (accountOld.getResidue()>=cost){
                accountOld.setUsed(accountOld.getUsed()+cost);
                accountOld.setResidue(accountOld.getTotal()-accountOld.getUsed());
                accountOld.setUserId(userId);
                int res = accountDao.debitAccount(accountOld);
                return res;
            }
            return -1;  //余额不足
        }

        return 0; //未找到用户
    }
}
