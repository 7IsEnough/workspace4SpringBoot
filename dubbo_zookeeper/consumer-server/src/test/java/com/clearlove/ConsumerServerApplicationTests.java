package com.clearlove;

import com.clearlove.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServerApplicationTests {

  @Autowired
  UserService userService;

  @Test
  void contextLoads() {
    userService.buyTicket();

  }
}
