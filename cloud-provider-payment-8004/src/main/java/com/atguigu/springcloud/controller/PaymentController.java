package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/24
 * Email:65489469@qq.com
 */
@RestController
@RequestMapping("payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment) {

        int i = paymentService.create(payment);

        if (i > 0){
            return new CommonResult(200,"插入成功",i);
        }else {
            return new CommonResult(444,"插入失败",null);

        }

    }

    @GetMapping("get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);

        if (payment != null){
            CommonResult commonResult = new CommonResult(200, "查询成功,端口号:"+serverPort, payment);

            return commonResult;
        }else {
            return new CommonResult(444,"数据不存在",null);
        }
    }

    //http://localhost:8004/payment/zk
    @GetMapping("zk")
    public String paymentZk(){

        return "springcloud with zookeeper:"+serverPort+" :: "+ UUID.randomUUID().toString();
    }
}
