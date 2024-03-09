package com.clearlove.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author promise
 * @date 2024/3/9 - 22:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private int id;
  private String name;
  private String pwd;

}
