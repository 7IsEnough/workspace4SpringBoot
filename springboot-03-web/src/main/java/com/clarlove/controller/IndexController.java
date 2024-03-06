package com.clarlove.controller;

import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author promise
 * @date 2024/3/6 - 22:59
 * 在templates目录下的所有页面，只能通过controller来跳转
 * 这个需要模板引擎的支持
 */
@Controller
public class IndexController {

  @RequestMapping("/index")
  public String index() {
    return "index";
  }


  @RequestMapping("/test")
  public String test(Model model) {
    model.addAttribute("msg", "<h1>hello,springBoot</h1>");

    model.addAttribute("users", Arrays.asList("kobe", "bryant"));

    return "test";
  }

}
