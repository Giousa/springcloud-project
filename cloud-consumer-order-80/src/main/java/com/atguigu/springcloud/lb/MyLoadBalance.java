package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/27
 * Email:65489469@qq.com
 */
@Component
public class MyLoadBalance implements ILoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){

        int current;
        int next;
        do{
            current = this.atomicInteger.get();
//            next = current >= 2147483637 ? 0 : current+1;
            next = current >= Integer.MAX_VALUE ? 0 : current+1;

        }while (!this.atomicInteger.compareAndSet(current,next));

        System.out.println("当前访问次数current = "+current);
        System.out.println("下次访问next = "+next);

        return next;
    }

    @Override
    public ServiceInstance instanceList(List<ServiceInstance> instances) {


        int index = getAndIncrement() % instances.size();

        return instances.get(index);
    }
}
