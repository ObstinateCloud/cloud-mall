package com.legendyun.order.dao;

import com.legendyun.common.entities.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @title: OrderDao
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/27 11:19
 */

@Mapper
public interface OrderDao {


    int insertOrder(Order order);

    Order getOrderById(Long id);

    int updateOrderStatus(Long id);
}
