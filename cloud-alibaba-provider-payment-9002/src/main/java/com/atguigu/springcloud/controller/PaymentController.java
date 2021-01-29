package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: PaymentController
 * @description:
 * @author: zmm
 * @create: 2020-06-10 16:22
 */

@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    //http://localhost:9001/payment/nacos/1
    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }
}
