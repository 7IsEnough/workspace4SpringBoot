package com.clarlove.controller;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author promise
 * @date 2024/3/5 - 0:32
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

  @GetMapping("/hello")
  @ResponseBody
  public String hello() {
    try {
      return "hello：my host ip is: " + Inet4Address.getLocalHost().getHostAddress() + "hostname is: " + Inet4Address.getLocalHost().getHostName();
    } catch (UnknownHostException e) {
      throw new RuntimeException(e);
    }
  }

}
