package com.clearlove.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author promise
 * @date 2024/3/12 - 23:32
 */
@Service
@Component
public class TicketServerImpl implements TicketServer {


  @Override
  public String getTicket() {
    return "kobe";
  }

}
