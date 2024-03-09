package com.clarlove.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author promise
 * @date 2024/3/9 - 21:02
 */
@Configuration
public class DruidConfig {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource druidDataSource() {
    return new DruidDataSource();
  }

  // druid后台监控
  // 相当于web.xmL,ServLetRegistrationBean
  // 因为SpringBoot内置了servlet容器，所以没有web.xmL,替代方法：ServLetRegistrationBean
  @Bean
  public ServletRegistrationBean statViewServlet() {
    ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(
        new StatViewServlet(), "/druid/*");
    // 后台登录账号密码配置
    // 设置初始化参数
    Map<String, String> initParams = new HashMap<>();
    initParams.put("loginUsername", "admin");
    initParams.put("loginPassword", "123456");  // 登录的key是固定的

    // 允许谁能访问
    initParams.put("allow","");


    // 禁止谁访问
//    initParams.put("clearlove", "192.168.1.1");



    bean.setInitParameters(initParams);
    return bean;
  }

  @Bean
  public FilterRegistrationBean webStatFilter() {
    FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
    bean.setFilter(new WebStatFilter());
    // 设置初始化参数
    Map<String, String> initParams = new HashMap<>();

    // 这些资源不进行统计
    initParams.put("exclusions","*.js,*.css,/druid/**");

    bean.setInitParameters(initParams);
    return bean;
  }

}
