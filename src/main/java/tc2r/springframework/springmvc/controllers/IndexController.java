package tc2r.springframework.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // makes a spring component a controller
public class IndexController {


  @RequestMapping("/")
  public String index(){
    // this method makes spring mvc look for a thymeleaf template
    // by the name of "index" because that is what is returned.
    return "index";
  }
}
