package com.clearlove.mapper;

import com.clearlove.pojo.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author promise
 * @date 2024/3/9 - 22:48
 */

// 这个注解表示这是一个 mybatis 的 mapper 类
//@Mapper
//@Repository
public interface UserMapper {

  List<User> queryUserList();
  User queryUserById(int id);
  int addUser(User user);
  int updateUser(User user);
  int deleteUser(int id);

}
