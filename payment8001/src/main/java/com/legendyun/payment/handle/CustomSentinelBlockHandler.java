package com.legendyun.payment.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.legendyun.common.entities.CommonResult;

/**
 * @title: CustomSentinelBlockHandler
 * @description: 自定义Sentinel异常处理
 * @auther: zhangjianyun
 * @date: 2023/12/26 14:24
 */
public class CustomSentinelBlockHandler {

    public static CommonResult handlerException1(BlockException blockException){ //参数和返回值类型必须和请求的的方法一致否则无法匹配
        return new CommonResult(444,"sentinel全局异常处理方法1："+blockException.getMessage());
    }

    public static CommonResult handlerException2(BlockException blockException){
        return new CommonResult(554,"sentinel全局异常处理方法2："+blockException.getMessage());
    }
}
