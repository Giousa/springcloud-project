package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/27
 * Email:65489469@qq.com
 */
public interface ILoadBalance {

    ServiceInstance instanceList(List<ServiceInstance> instances);

}
