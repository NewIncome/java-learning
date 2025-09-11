package com.jalfredev.taco_cloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jalfredev.taco_cloud.Order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
  
  @PostMapping
  public String processOrder(Order order) { //this order object will receive the form fields
    log.info("Order submitted: " + order);
    return "redirect:/";
  }

}
