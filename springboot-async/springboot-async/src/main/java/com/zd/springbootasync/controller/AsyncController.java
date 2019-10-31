package com.zd.springbootasync.controller;

import com.zd.springbootasync.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/async")
    public String handler01() {
        //在这里调用异步方法
        asyncService.service01();
        return "success";
    }
}
