package com.ll.demo.handler.test.filterChain;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 安全校验对象
 */
@Component
@Order(2) //校验顺序排第2
public class CheckSecurityFilterObject extends AbstractHandler {

    @Override
    public void doFilter(String request, String response) {
        //invoke Security check
        System.out.println("安全调用校验");
    }
}