package com.clarlove.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author promise
 * @date 2024/3/5 - 22:45
 */
@Component
@ConfigurationProperties(prefix = "person")

// javaConfig 绑定我们配置文件的值，可以采取这些方式
// 加载指定的配置文件
//@PropertySource(value = "classpath:kobe.properties")
@Validated // 数据校验
public class Person {

  // SPEL表达式
//  @Value("${name}")
  private String name;
  private Integer age;
  private Boolean happy;
  private Date birth;

//  @Email(message = "邮箱格式错误")
  private String email;
  private Map<String,Object> maps;
  private List<Object> lists;
  private Dog dog;

  public Person() {
  }

  public Person(String name, Integer age, Boolean happy, Date birth, Map<String, Object> maps,
      List<Object> lists, Dog dog) {
    this.name = name;
    this.age = age;
    this.happy = happy;
    this.birth = birth;
    this.maps = maps;
    this.lists = lists;
    this.dog = dog;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Boolean getHappy() {
    return happy;
  }

  public void setHappy(Boolean happy) {
    this.happy = happy;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public Map<String, Object> getMaps() {
    return maps;
  }

  public void setMaps(Map<String, Object> maps) {
    this.maps = maps;
  }

  public List<Object> getLists() {
    return lists;
  }

  public void setLists(List<Object> lists) {
    this.lists = lists;
  }

  public Dog getDog() {
    return dog;
  }

  public void setDog(Dog dog) {
    this.dog = dog;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", happy=" + happy +
        ", birth=" + birth +
        ", maps=" + maps +
        ", lists=" + lists +
        ", dog=" + dog +
        '}';
  }
}
