package com.jalfredev.taco_cloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j        //Logger
@Controller
@RequestMapping("/orders")
public class OrderController {
/* specifies that any request-handling methods in
 * this controller will handle requests whose path begins with /orders
 */

  @GetMapping("/current")
  public String orderForm(Model model) {
    model.addAttribute("order", new Order());

      return "orderForm";
  }
  
}
