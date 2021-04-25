package com.code.fuqinqin.springcloudapi.springcloudproducer.controller;

import com.code.fuqinqin.springcloudapi.request.UserInfoRequest;
import com.code.fuqinqin.springcloudapi.response.UserInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user-info")
    public UserInfoResponse getUserInfo(@RequestBody UserInfoRequest request) {
        log.info("[HelloController-getUserInfo] request = {}", request);
        return UserInfoResponse.builder()
                .userId(request.getUserId() + 1)
                .userName("[HelloController-getUserInfo]" + request.getUserName())
                .age(request.getAge())
                .build();
    }

    @PostMapping("/user-info2")
    public UserInfoResponse getUserInfo2(@RequestBody UserInfoRequest request) {
        log.info("[HelloController-getUserInfo2] request = {}", request);
        return UserInfoResponse.builder()
                .userId(request.getUserId() + 2)
                .userName("[HelloController-getUserInfo2]" + request.getUserName())
                .age(request.getAge())
                .build();
    }

}
