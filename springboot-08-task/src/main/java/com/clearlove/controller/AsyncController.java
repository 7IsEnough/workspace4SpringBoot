package com.clearlove.controller;

import com.clearlove.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author promise
 * @date 2024/3/11 - 23:15
 */
@RestController
public class AsyncController {

  @Autowired
  private AsyncService asyncService;


  @RequestMapping("/hello")
  public String hello(){
    asyncService.hello(); // 停止三秒
    return "OK";
  }

}
