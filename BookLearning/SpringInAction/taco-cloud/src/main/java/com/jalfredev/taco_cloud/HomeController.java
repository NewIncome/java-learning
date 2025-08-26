package com.jalfredev.taco_cloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")   // Handles 'get' requests
  public String home() {
    return "home";
  }

}
