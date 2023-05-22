package com.ll.demo.service.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name = "hi-service", url = "http://localhost:8080")
public interface HelloServiceClient {
    @GetMapping("/hello")
    String hello();
}
