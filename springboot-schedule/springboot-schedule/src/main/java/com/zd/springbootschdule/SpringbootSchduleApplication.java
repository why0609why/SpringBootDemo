package com.zd.springbootschdule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//表示开启定时任务
@EnableScheduling
@SpringBootApplication
public class SpringbootSchduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSchduleApplication.class, args);
    }

}
