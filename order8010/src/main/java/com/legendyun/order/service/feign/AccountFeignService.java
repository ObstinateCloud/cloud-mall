package com.legendyun.order.service.feign;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.common.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @title: AccountFeignService
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/25 14:05
 */

@Component
@FeignClient(value = "payment8001/account/")
public interface AccountFeignService {

    @GetMapping(value = "debit/{userId}/{cost}")
    CommonResult<Integer> debitAccount(@PathVariable("userId") Integer userId,@PathVariable("cost") Integer cost);


}
