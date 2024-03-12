package com.clearlove.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author promise
 * @date 2024/3/12 - 23:32
 * zookeeper: 服务注册与发现
 */
@Component  // 使用了dubbo后尽量不要使用Service注解
@Service // 可以被扫描到，项目一启动就自动注册到注册中心
public interface TicketServer {


  public String getTicket();

}
