package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @className: StreamMQMain8801
 * @description:
 * @author: zmm
 * @create: 2020-06-10 12:31
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQApplication8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQApplication8801.class,args);
    }
}
