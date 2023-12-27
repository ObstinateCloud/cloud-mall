package com.legendyun.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @title: Order
 * @description: 订单
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:10
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private Long id;

    private int userId;

    private int productId;

    private int count;

    private int money;

    private int status;


}
