package com.clearlove.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author promise
 * @date 2024/3/10 - 17:36
 */
@RestController
@RequestMapping("/kobe")
public class HelloController {


  @RequestMapping("/hello")
  public String hello() {
    return "hello";
  }

}
