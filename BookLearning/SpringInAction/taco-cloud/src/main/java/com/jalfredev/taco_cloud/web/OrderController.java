package com.jalfredev.taco_cloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jalfredev.taco_cloud.Order;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j        //Logger
@Controller   //controller Bean
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
  public String processOrder(@Valid Order order, Errors errors) { //this order object will receive the form fields
    if(errors.hasErrors()) {
      log.info("Errors in Order obj: " + errors.getAllErrors());
      return "orderForm";
    }

    log.info("Order submitted: " + order);
    return "redirect:/";
  }

}
