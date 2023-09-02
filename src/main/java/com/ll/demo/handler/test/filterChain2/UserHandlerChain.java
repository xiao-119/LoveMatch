package com.ll.demo.handler.test.filterChain2;

import com.ll.demo.entity.User;

public class UserHandlerChain extends FilterChain<User> {

    public static UserHandlerChain build() {
        return new UserHandlerChain();
    }

    public UserHandlerChain addFilter(UserHandler handler) {
        list.add(handler);
        return this;
    }
}
