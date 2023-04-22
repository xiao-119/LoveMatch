package com.ll.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


@Service
public class AsyncTask {


    @Async("asyncThreadPool")
    public void doSomethingAsync() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println("Current thread name: " + threadName);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Async("asyncThreadPool")
    public Future<String> asyncMethodWithReturn() {
        // 异步执行的方法体
        return new AsyncResult<>("异步方法返回值");
    }
}
