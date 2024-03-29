package com.clarlove.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author promise
 * @date 2024/3/6 - 23:46
 * 全面扩展 SpringMVC
 */
@Configuration
// @EnableWebMvc // 这玩意就是导入了一个类：DelegatingWebMvcConfiguration.class  从容器中获取所有的webMvcConfig，但会让默认的配置失效
public class MyMvcConfig implements WebMvcConfigurer {

  // 视图跳转
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/kobe").setViewName("test");

  }

  // 自定义的国际化组件
  @Bean(value = "localeResolver")
  public LocaleResolver MyLocaleResolver() {
    return new MyLocaleResolver();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/user/login", "/css/*","/js/**","/img/**");
  }

  // public interface viewResolver 实现了视图解析器接口的类，我们就可以把它看做视图解析器

//  @Bean
//  public ViewResolver myViewResolver() {
//    return new MyViewResolver();
//  }


  // 如果。你想diy一些定制化的功能，只要写这个组件，然后将它交给springBoot,springBoot就会帮我们自动装配！


  // 自定义了一个视图解析器
//  public static class MyViewResolver implements ViewResolver {
//
//    @Override
//    public View resolveViewName(String s, Locale locale) throws Exception {
//      return null;
//    }
//  }

}
