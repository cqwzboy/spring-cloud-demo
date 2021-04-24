package com.code.fuqinqin.springcloudapi.springcloudconsumer.controller;

import com.code.fuqinqin.springcloudapi.request.UserInfoRequest;
import com.code.fuqinqin.springcloudapi.response.UserInfoResponse;
import com.code.fuqinqin.springcloudapi.springcloudconsumer.feign.IHelloClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private IHelloClient helloClient;

    @GetMapping("/hello")
    public String consumer() {
        String value = helloClient.sayHello();
        LOGGER.info("value = {}", value);
        return value;
    }

    @GetMapping("/user-info")
    public UserInfoResponse getUserInfo(
            @RequestParam("userId") Long userId,
            @RequestParam("userName") String userName,
            @RequestParam("age") Integer age) {
        LOGGER.info("[getUserInfo] userId = {}, userName = {}, age = {}",
                userId, userName, age);
        UserInfoRequest request = new UserInfoRequest();
        request.setUserId(userId + 22);
        request.setUserName("[" + userName + "]");
        request.setAge(age * 2);
        return helloClient.getUserInfo(request);
//        return helloClient.getUserInfo(UserInfoRequest.builder()
//                .userId(userId + 22)
//                .userName("[" + userName + "]")
//                .age(age * 2)
//                .build());
    }

    @GetMapping("/user-info2")
    public UserInfoResponse getUserInfo2(
            @RequestParam("userId") Long userId,
            @RequestParam("userName") String userName,
            @RequestParam("age") Integer age) {
        LOGGER.info("[getUserInfo2] userId = {}, userName = {}, age = {}",
                userId, userName, age);
        UserInfoRequest request = new UserInfoRequest();
        request.setUserId(userId + 22);
        request.setUserName("<" + userName + ">");
        request.setAge(age * 2);
        return helloClient.getUserInfo2(request);
//        return helloClient.getUserInfo2(UserInfoRequest.builder()
//                .userId(userId + 22)
//                .userName("<" + userName + ">")
//                .age(age * 2)
//                .build());
    }
}
