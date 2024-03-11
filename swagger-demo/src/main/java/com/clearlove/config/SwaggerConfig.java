package com.clearlove.config;

import java.util.ArrayList;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author promise
 * @date 2024/3/10 - 17:44
 */
@Configuration
@EnableSwagger2 // 开启swagger2
public class SwaggerConfig {


  @Bean
  public Docket docket1() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("A");
  }

  @Bean
  public Docket docket2() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("B");
  }

  @Bean
  public Docket docket3() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("C");
  }



  // 配置了Swagger 的Docket 的bean实例
  // enable是否启动swagger，如果为false，则swagger不能在浏览器中访问
  @Bean
  public Docket docket(Environment env) {

    //设置要显示的Swagger环境
    Profiles profiles = Profiles.of("dev","test");

    //通过environment,acceptsProfiles判断是否处在自己设定的环境当中
    boolean flag = env.acceptsProfiles(profiles);


    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .groupName("kobe")
        .enable(true)
        .select()
        // RequestHandlerSelectors 配置要扫描接口的方式
        // basePackage  指定要扫描的包
        // any()  扫描全部
        // none() 都不扫描
        // withClassAnnotation  扫描类上的注解，参数是一个注解的反射对象
        // withMethodAnnotation  扫描方法上的注解
        .apis(RequestHandlerSelectors.basePackage("com.clearlove.controller"))
        // 过滤路径
        .paths(PathSelectors.ant("/kobe/**"))
        .build();
  }


  // 配置swagger信息---apiInfo
  private ApiInfo apiInfo() {

    // 作者信息
    Contact contact = new Contact("promise", "http://www.bilibili.com", "kobebean2824@163.com");

    return new ApiInfo(
        "SwaggerAPI文档",
        "总有地面上的生灵，敢于直面雷霆的威光",
        "v1.0",
        "http://www.bilibili.com",
        contact,
        "Apache 2.0",
        "http://www.apache.org/licenses/LICENSE-2.0",
        new ArrayList<>()
    );

  }

}
