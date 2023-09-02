package com.ll.demo.handler.test.filterChain2;

import java.util.ArrayList;
import java.util.List;

public abstract class FilterChain<T> {

    List<FilterHandler<T>> list = new ArrayList<>();

    public final void filter(T param, FilterChainResp resp) {

        for (FilterHandler<T> handler : list) {
            handler.doFilter(param, resp);
            if (resp.getCode() != null) {
                return;
            }
        }
    }
//    public FilterChain<T> addFilter(FilterHandler<T> handler) {
//        list.add(handler);
//        return this;
//    }

//    public abstract FilterChain<T> addFilter(UserHandler handler);

//    public static <E> FilterChain<E> build(){
//        return new FilterChain<>();
//    }
}
