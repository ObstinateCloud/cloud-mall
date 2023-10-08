package com.legendyun.payment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: CommonResult
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
