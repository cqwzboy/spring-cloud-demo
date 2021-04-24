package com.code.fuqinqin.springcloudconsumer.controller;

import com.code.fuqinqin.springcloudconsumer.feign.IHelloClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private IHelloClient helloClient;

    @GetMapping(value = "/hello")
    public String consumer() {
        String value = helloClient.sayHello();
        LOGGER.info("value = {}", value);
        return value;
    }
}
