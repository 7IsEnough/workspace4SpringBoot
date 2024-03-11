package com.clearlove.controller;

import com.clearlove.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author promise
 * @date 2024/3/10 - 17:36
 */
@Api(tags = "Hello控制类")
@RestController
@RequestMapping("/kobe")
public class HelloController {


  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }


  // 只要我们的接口中，返回值中存在实体类，就会被扫描到Swagger中
  @PostMapping("/user")
  public User user() {
    return new User();
  }

  //Operation接口，不能作用在类上，是方法
  @ApiOperation("Hello接口")
  @GetMapping(value ="/hello2")
  public String hello2(@ApiParam("用户名") String username) {
    return "hello" + username;
  }


  @ApiOperation("post测试类")
  @PostMapping("/postt")
  public User postt(@ApiParam("用户名")User user) {
//    int i = 5/0;
    return user;
  }
}
