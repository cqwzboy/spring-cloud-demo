package com.code.fuqinqin.springcloudapi.springcloudproducer.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public String sayHello(){
        String value = "Hello, today is " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        LOGGER.info("value = {}", value);
        return value;
    }

}
