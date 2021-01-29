package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
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


    //单机版
//    public static final String PAYMENT_URL = "http://localhost:8001/";
    //Eureka
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyLoadBalance myLoadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"payment/create",payment,CommonResult.class);
    }


    //http://localhost:80/order/consumer/payment/get/1
    @GetMapping("consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        logger.info("getPaymentById id = "+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


    //http://localhost:80/order/consumer/payment/getForEntity/1
    @GetMapping("consumer/payment/getForEntity/{id}")
    public CommonResult getForEntity(@PathVariable("id") Long id){

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        System.out.println("请求返回结果：：：：");
        System.out.println(entity.toString());
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }

        return new CommonResult(444,"请求失败",null);
    }


    //http://localhost/order/lb
    @GetMapping("lb")
    public String getPaymentLB() {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");


        if(instances == null || instances.size() == 0 ){
            return "查询失败";
        }

        ServiceInstance serviceInstance = myLoadBalance.instanceList(instances);
        URI uri = serviceInstance.getUri();

//        return restTemplate.getForObject(PAYMENT_URL + "/payment/lb",String.class);
        return restTemplate.getForObject(uri + "/payment/lb",String.class);
    }

    //http://localhost/order/consumer/payment/zipkin
    @GetMapping("consumer/payment/zipkin")
    public String zipkinTest(){
        System.out.println("order zipkin 测试");

        return restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin",String.class);
    }

}
