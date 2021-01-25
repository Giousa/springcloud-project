package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/24
 * Email:65489469@qq.com
 */
@Service
public class PaymentServiceImpl implements PaymentService {



    //Spring的
    @Autowired
    private PaymentDao paymentDao;

    //java自带的
//    @Resource
//    private PaymentDao paymentDao;



    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

//        long preTime = System.currentTimeMillis();
//        for (int i = 0; i < 1000; i++) {
//            paymentDao.getPaymentById(id);
//        }
//
//        long l = System.currentTimeMillis() - preTime;
//        System.out.println("1000次查询间隔时间："+l/1000+"秒");//15秒，待优化

        return paymentDao.getPaymentById(id);
    }
}
