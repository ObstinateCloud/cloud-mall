package com.legendyun.order.mylb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title: LoadBalancer
 * @description: 参照RandomRule 类初始化需要ILoadBalancer 接口实现
 *   参照 RoundRobinRule
 * @auther: zhangjianyun
 * @date: 2023/10/25 10:52
 */
@Component
public class ZjyLoadBalancer implements MyLoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current=0; //当前请求总数
        int next=0; //第几次访问
        do {
            System.out.println("before next:"+next);
            System.out.println("before current:"+current);
            System.out.println("before atomicInteger:"+atomicInteger);
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current,next)); //cas乐观锁
        System.out.println("after next:"+next);
        System.out.println("after current:"+current);
        System.out.println("after atomicInteger:"+atomicInteger);
        return next;
    }

    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
