package com.clearlove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
// 开启异步注解功能
@EnableAsync
public class Springboot08TaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot08TaskApplication.class, args);
  }

}
