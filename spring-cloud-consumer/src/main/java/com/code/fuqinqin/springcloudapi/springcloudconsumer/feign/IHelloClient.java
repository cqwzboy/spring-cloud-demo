package com.code.fuqinqin.springcloudapi.springcloudconsumer.feign;

import com.code.fuqinqin.springcloudapi.request.UserInfoRequest;
import com.code.fuqinqin.springcloudapi.response.UserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(value = "HELLO-SERVICE-PROVIDER")
public interface IHelloClient {
    @GetMapping("/hello")
    String sayHello();

    @PostMapping("/hello/user-info")
    UserInfoResponse getUserInfo(UserInfoRequest request);

    @PostMapping("/hello/user-info2")
    UserInfoResponse getUserInfo2(UserInfoRequest request);
}
