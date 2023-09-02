package com.ll.demo.handler.test.filterChain2;

@FunctionalInterface
public interface FilterHandler<E> {
    void doFilter(E param, FilterChainResp resp);
}
