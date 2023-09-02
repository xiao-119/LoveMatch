package com.ll.demo.handler.test.filterChain2;

import com.ll.demo.entity.User;

@FunctionalInterface
public interface UserHandler extends FilterHandler<User> {
    @Override
    void doFilter(User param, FilterChainResp resp);
}
