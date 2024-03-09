package com.clearlove.controller;

import com.clearlove.mapper.UserMapper;
import com.clearlove.pojo.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author promise
 * @date 2024/3/9 - 23:03
 */
@RestController
public class UserController {

  @Autowired
  private UserMapper userMapper;

  @GetMapping("/queryUserList")
  public List<User> queryuserList() {
    List<User> userList = userMapper.queryUserList();
    for (User user: userList) {
      System.out.println(user);
    }
      return userList;

  }

  // 添加一个用户
  @GetMapping("/addUser")
  public String addUser(){
    userMapper.addUser(new User(5,"阿毛","456789"));
    return "ok";
  }
  // 修改一个用户
  @GetMapping("/updateUser")
  public String updateUser(){
    userMapper.updateUser(new User(5,"阿毛","421319"));
    return "ok";
  }
  // 根据id删除用户
  @GetMapping("/deleteUser")
  public String deleteUser() {
    userMapper.deleteUser(5);
    return "ok";
  }

}
