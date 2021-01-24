package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

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

    Logger logger = Logger.getLogger(OrderController.class.getName());


    public static final String PAYMENT_URL = "http://localhost:8001/";

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"payment/create",payment,CommonResult.class);
    }


    @GetMapping("consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        logger.info("getPaymentById id = "+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}
