package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: SendMessageController
 * @description:
 * @author: liusCoding
 * @create: 2020-06-10 12:37
 */

@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    //http://localhost:8801/sendMessage
    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
