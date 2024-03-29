package com.clearlove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 开启异步注解功能
@EnableAsync
// 开启定时功能的注解
@EnableScheduling
public class Springboot08TaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot08TaskApplication.class, args);
  }

}
