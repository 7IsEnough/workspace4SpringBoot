package com.clearlove.controller;

import com.clearlove.service.TicketServer;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author promise
 * @date 2024/5/18 - 16:02
 */
@RestController
@RequestMapping("/test")
public class TestController {

  // 想拿到provider-server提供的票，要去注册中心拿到服务
  @Reference  //引用 定义路径相同的接口名
  TicketServer ticketServer;

  @GetMapping("/test")
  public String buyTicket() {
    String ticket = ticketServer.getTicket();
    System.out.println("在注册中心拿到：" + ticket);
    return "在注册中心拿到：" + ticket;
  }
}
