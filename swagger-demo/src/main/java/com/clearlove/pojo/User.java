package com.clearlove.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author promise
 * @date 2024/3/11 - 22:26
 */
@Data
@ApiModel("用户实体类")
// @Api("注释")
public class User {

  @ApiModelProperty("用户名")
  private String username;

  @ApiModelProperty("密码")
  private String password;

}
