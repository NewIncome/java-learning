package com.jalfredev.taco_cloud;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jalfredev.taco_cloud.Ingredient.Type;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j          //Generates a Logger in the class
@Controller     //Mark the class as a candidate for component scanning
@RequestMapping("/design")  //Map web requests to specific methods in a controller class
public class DesignTacoController {

  /* @GetMapping Specifies that when an HTTP GET request is received for the page specified
   * in the @RequestMapping, the following method will be called to handle the request
   */
  @GetMapping
  public String showDesignForm(Model model) {
    /* Model is an object that ferries data between a controller and whatever view is charged with rendering that data */

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
    for(Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
        filterByType(ingredients, type));
    }

    model.addAttribute("design", new Taco());

    //the logical name of the view that will be used to render the model to the browser
    return "design";
  }
  
}
