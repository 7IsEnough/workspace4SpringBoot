package com.clarlove.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author promise
 * @date 2024/3/6 - 22:32
 */
@RestController
public class HelloController {

  @RequestMapping("/hello")
  public String hello() {

    return "hello,world";

  }

}
