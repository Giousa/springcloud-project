package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: PaymentController
 * @description:
 * @author: zmm
 * @create: 2020-06-08 10:32
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

//    private final PaymentService paymentService;

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }


    //http://localhost:8001/payment/hystrix/ok/1
    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoOK(id);
        log.info("----result-------："+ result);
        return result;
    }

    //http://localhost:8001/payment/hystrix/timeout/1
    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("----result-------："+ result);
        return result;
    }

    //====服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }
}
