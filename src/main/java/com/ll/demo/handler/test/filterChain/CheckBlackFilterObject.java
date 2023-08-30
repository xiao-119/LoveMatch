package com.ll.demo.handler.test.filterChain;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 黑名单校验对象
 */
@Component
@Order(3) //校验顺序排第3
public class CheckBlackFilterObject extends AbstractHandler {

    @Override
    public void doFilter(String request, String response) {
        //invoke black list check
        System.out.println("校验黑名单");
    }
}