package com.legendyun.payment.controller;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.common.entities.Payment;
import com.legendyun.payment.service.AccountService;
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
@RequestMapping("account")
@Slf4j
public class AccountController {
    @Resource
    private AccountService accountService;

    @GetMapping(value = "debit/{userId}/{cost}")
    public CommonResult<Integer> debitAccount(@PathVariable("userId") Integer userId,@PathVariable("cost") Integer cost){
        int result = accountService.debitAccount(userId,cost);
        CommonResult<Integer> commonResult = null;
        if (result == 1) {
            commonResult = new CommonResult(200, "更新账户成功",result);
        }else if (result==-1){
            commonResult = new CommonResult(201, "更新账户失败-用户余额不足",result);
        }else if (result==0){
            commonResult = new CommonResult(201, "更新账户失败-未找到用户",result);
        }
        return commonResult;
    };
}
