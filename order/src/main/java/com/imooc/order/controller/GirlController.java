package com.imooc.order.controller;

import com.imooc.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试拉取git上的配置文件属性
 */
@RequestMapping("/girl")
@RestController
public class GirlController {

    @Autowired
    private GirlConfig config;


    @GetMapping("/print")
    public String print() {
        return "name" + config.getName() + ", age" + config.getAge();
    }


}
