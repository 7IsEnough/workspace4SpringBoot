package com.clearlove.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
@author promise
@date 2024/3/12 - 21:24
*/
@Service
public class ScheduledService {

  // 在一个特定的时间执行这个方法
  // cron表达式
  // 秒 分 时 日 月  周几
  @Scheduled(cron = "0 43 21 * * ?")
  public void hello() {
    System.out.println("hello,你被执行了");
  }

}
