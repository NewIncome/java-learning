package com.jalfredev.taco_cloud.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import com.jalfredev.taco_cloud.Ingredient;
import com.jalfredev.taco_cloud.Ingredient.Type;
import com.jalfredev.taco_cloud.Taco;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j          //Generates a Logger in the class
@Controller     //Mark the class as a candidate for component scanning
@RequestMapping("/design")  //Map web requests to specific methods in a controller class
public class DesignTacoController {
 
  /* Model is an object that ferries data between a controller and whatever view is charged with rendering that data
   * 
   */
  @ModelAttribute
  public void addIngredientsToModel(Model model) {
    //hardcoded list of ingredients, for now...
    List<Ingredient> ingredients = Arrays.asList(
      new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
      new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
      new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
      new Ingredient("CARN", "Carnitas", Type.PROTEIN),
      new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
      new Ingredient("LETC", "Lettuce", Type.VEGGIES),
      new Ingredient("CHED", "Cheddar", Type.CHEESE),
      new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
      new Ingredient("SLSA", "Salsa", Type.SAUCE),
      new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
    );
    
    //filters the list by ingredient type
    Type[] types = Ingredient.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
          filterByType(ingredients, type));
    }
  }

  private List<Ingredient> filterByType(List<Ingredient> ingredients,
                                        Type type) {
      return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }

  /* @GetMapping Specifies that when an HTTP GET request is received for the page specified
   * in the @RequestMapping, the following method will be called to handle the request
   */
  @GetMapping
  public String showDesignForm(Model model) {
    model.addAttribute("design", new Taco());
    //the logical name of the view that will be used to render the model to the browser
    return "design";
  }

  //TODO: process POST request
  @PostMapping
  public String processDesign(@Valid @ModelAttribute("design") Taco design,
                              Errors errors, Model model) {
      if(errors.hasErrors()) return "design";

      // Save taco design later...
      log.info("Processing design: " + design);
      
      return "redirect:/orders/current";
  }
  

}
