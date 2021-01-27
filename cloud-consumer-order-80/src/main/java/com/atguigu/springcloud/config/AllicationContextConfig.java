package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Description: 目的是为了配合RestTemplate远程调用
 *
 * 这样的话，我们后面，就可以通过注解的时候，直接获取到RestTemplate对象
 *
 * 说白了，就是讲RestTemplate生成单例，注入到Bean的单例池中
 *
 * Author:zhangmengmeng
 * Date:2021/1/24
 * Email:65489469@qq.com
 */
@Configuration
public class AllicationContextConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }

}
