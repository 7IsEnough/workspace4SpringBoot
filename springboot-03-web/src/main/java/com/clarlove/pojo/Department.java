package com.clarlove.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author promise
 * @date 2024/3/7 - 21:11
 * 部门表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

  private Integer id;

  private String departmentName;

}
