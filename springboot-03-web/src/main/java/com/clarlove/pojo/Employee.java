package com.clarlove.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author promise
 * @date 2024/3/7 - 21:31
 * 员工表
 */
@Data
@NoArgsConstructor
public class Employee {

  private Integer id;
  private String lastName;
  private String email;
  private Integer gender; //0: 女 1:男
  private Department department;
  private Date birth;


  public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
    this.id = id;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.department = department;
    // 默认的创建日期
    this.birth = new Date();
  }
}
