package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2021/1/24
 * Email:65489469@qq.com
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenfeignMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderOpenfeignMain80.class,args);
    }
}
