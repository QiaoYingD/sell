package com.imooc.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试拉取git上的配置文件属性
 */
@RequestMapping("/env")
@RestController
@RefreshScope
public class EnvController {


    @Value("${env}")
    private String env;


    @GetMapping("/print")
    public String print() {
        return env;
    }


}
