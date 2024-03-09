package com.clearlove.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author promise
 * @date 2024/3/10 - 0:44
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  // 授权规则
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 首页所有人都可以访问，功能页只有对应有权限的人才可以访问
    // 请求授权的规则
    http.authorizeHttpRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/level1/**").hasRole("vip1")
        .antMatchers("/level2/**").hasRole("vip2")
        .antMatchers("/level3/**").hasRole("vip3");

    // 没有权限，默认会跳到登录页面，需要开启登录的页面
    //  /login
    // loginPage  定制登录页
    http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");

    // 开启注销功能
    http.csrf().disable(); // 关闭防止跨站脚本请求攻击
    http.logout().logoutSuccessUrl("/");

    // 开启记住我功能  cookie实现，默认保存2周
    http.rememberMe().rememberMeParameter("remember");
  }


  // 认证规则
  // 密码编码：PasswordEncoder
  // 在Spring Secutiry5.0+新增了很多的加密方法
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // 这些数据正常应该从数据库读
    auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        .withUser("kobe").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
        .and()
        .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
        .and()
        .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");

  }
}
