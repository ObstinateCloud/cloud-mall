package com.legendyun.order.mylb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @title: LoadBalancer
 * @description: 参照RandomRule 类初始化需要ILoadBalancer 接口实现
 * @auther: zhangjianyun
 * @date: 2023/10/25 10:52
 */

public interface MyLoadBalancer {

    //从服务对象列表中选取一个
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
