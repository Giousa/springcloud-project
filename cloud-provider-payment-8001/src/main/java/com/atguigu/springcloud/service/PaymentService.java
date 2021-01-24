package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/24
 * Email:65489469@qq.com
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id")Long id);
}
