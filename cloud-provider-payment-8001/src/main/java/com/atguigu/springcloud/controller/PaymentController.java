package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment) {
        System.out.println("准备创建：");

        int i = paymentService.create(payment);

        if (i > 0){
            return new CommonResult(200,"插入成功",i);
        }else {
            return new CommonResult(444,"插入失败",null);

        }

    }

    @GetMapping("get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        System.out.println("准备查询：");

        Payment payment = paymentService.getPaymentById(id);
        System.out.println("查询结果：");
        System.out.println(payment);

        if (payment != null){
            CommonResult commonResult = new CommonResult(200, "查询成功", payment);
            System.out.println(commonResult);
            return commonResult;
        }else {
            return new CommonResult(444,"数据不存在",null);
        }
    }
}
