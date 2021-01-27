package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.FeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/24
 * Email:65489469@qq.com
 */
@RestController
@RequestMapping("order")
@CrossOrigin
@Slf4j
public class OrderController {


    @Autowired
    private FeignPaymentService feignPaymentService;

    //http://localhost/order/consumer/payment/get/1
    @GetMapping("consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        System.out.println("发起请求：");

        return feignPaymentService.getPaymentById(id);
    }

    //http://localhost/order/consumer/payment/openfeign/timeout
    @GetMapping("consumer/payment/openfeign/timeout")
    public String openFeignTimeout(){

        System.out.println("发起请求：");

        return feignPaymentService.openFeignTimeout();
    }

}
