package com.clearlove.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author promise
 * @date 2024/3/12 - 23:37
 */
@Service // 加入到容器中
public class UserService {

  // 想拿到provider-server提供的票，要去注册中心拿到服务
  @Reference  //引用 定义路径相同的接口名
  TicketServer ticketServer;

  public void buyTicket() {
    String ticket = ticketServer.getTicket();
    System.out.println("在注册中心拿到：" + ticket);
  }

}
