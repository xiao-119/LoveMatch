package com.ll.demo.controller;


import com.ll.demo.common.R;
import com.ll.demo.entity.User;
import com.ll.demo.service.client.HelloServiceClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Tag(name = "测试接口",description = "测试接口description")
@RestController
@RequestMapping("/test")
public class TestController {


    @Operation(summary = "测试接口hello", description = "测试接口description", tags = {"测试接口tags", "测试接口tags2"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = User.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})

    @RequestMapping("/test")
    public R<?> testGet() {
        return R.success("Hello World");
    }


    @RequestMapping("/testAsync")
    public Callable<String> callable() {
        return () -> {
            TimeUnit.SECONDS.sleep(10);
            return "async";
        };
    }


    @Autowired
    private HelloServiceClient helloServiceClient;

    @GetMapping("/feign")
    public String feign() {
        return helloServiceClient.hello();
    }
}
