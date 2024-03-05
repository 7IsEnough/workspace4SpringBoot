package com.clarlove.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author promise
 * @date 2024/3/5 - 22:43
 */
@Component
@ConfigurationProperties(prefix = "dog")
public class Dog {

  private String name;

  private Integer age;

  private String firstName;

  public Dog() {
  }

  public Dog(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public Dog(String name, Integer age, String firstName) {
    this.name = name;
    this.age = age;
    this.firstName = firstName;
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String toString() {
    return "Dog{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", firstName='" + firstName + '\'' +
        '}';
  }
}
