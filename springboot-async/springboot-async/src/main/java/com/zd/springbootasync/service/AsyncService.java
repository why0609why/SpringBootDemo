package com.zd.springbootasync.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AsyncService {

    //加了这个注解表示是异步方法，别的方法在调用这个方法的时候会在别的方法中的代码块中异步执行这个方法
    @Async
    public void service01() {
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
