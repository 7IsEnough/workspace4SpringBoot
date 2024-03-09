package com.clarlove.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author promise
 * @date 2024/3/9 - 18:30
 */
@RestController
public class JDBCController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/userList")
  public List<Map<String, Object>> userList() {
    String sql = "select * from user";
    return jdbcTemplate.queryForList(sql);
  }


  @GetMapping("/addUser")
  public String addUser() {
    String sql = "insert into mybatis.user(id,name,pwd) values(4,'小明', '123456')";
    jdbcTemplate.update(sql);
    return "insert-ok";
  }

  @GetMapping("/updateUser/{id}")
  public String updateUser(@PathVariable("id") int id) {
    String sql = "update mybatis.user set name=?,pwd=? where id=" + id;
    // 封装
    Object[] params = new Object[2];
    params[0] = "小明2";
    params[1] = "zzzzzzzzz";
    jdbcTemplate.update(sql, params);
    return "update-ok";
  }


  @GetMapping("/deleteUser/{id}")
  public String deleteUser(@PathVariable("id") int id) {
    String sql = "delete from mybatis.user where id=?";
    jdbcTemplate.update(sql, id);
    return "deleteUser-ok";
  }

}
