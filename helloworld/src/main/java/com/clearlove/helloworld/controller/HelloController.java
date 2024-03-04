package com.clearlove.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author promise
 * @date 2024/3/5 - 0:12
 */
@RestController
public class HelloController {

  // http://localhost:8080/hello
  @RequestMapping("/hello")
  public String hello() {
    // 调用业务，接收前端的参数
    return "hello,World";
  }

}
