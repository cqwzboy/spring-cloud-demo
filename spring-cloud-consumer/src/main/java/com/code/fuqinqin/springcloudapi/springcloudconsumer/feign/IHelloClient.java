package com.code.fuqinqin.springcloudapi.springcloudconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "HELLO-SERVICE-PROVIDER")
public interface IHelloClient {
    @GetMapping("/hello")
    String sayHello();
}
