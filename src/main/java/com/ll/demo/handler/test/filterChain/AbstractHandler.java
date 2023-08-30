package com.ll.demo.handler.test.filterChain;

/**
 * 关注公众号：捡田螺的小男孩
 */
public abstract class AbstractHandler {

    //责任链中的下一个对象
    private AbstractHandler nextHandler;

    /**
     * 具体参数拦截逻辑,给子类去实现
     */
    public void filter(String request, String response) {
        doFilter(request, response);
        if (getNextHandler() != null) {
            getNextHandler().filter(request, response);
        }
    }

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    /**
     * 责任链的下一个对象
     */
    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void doFilter(String filterRequest, String response);

}