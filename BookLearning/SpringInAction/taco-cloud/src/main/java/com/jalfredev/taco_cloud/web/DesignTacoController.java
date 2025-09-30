package com.jalfredev.taco_cloud.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

import com.jalfredev.taco_cloud.Ingredient;
import com.jalfredev.taco_cloud.Ingredient.Type;
import com.jalfredev.taco_cloud.data.IngredientRepository;
import com.jalfredev.taco_cloud.data.TacoRepository;
import com.jalfredev.taco_cloud.Taco;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j          //Generates a Logger in the class
@Controller     //Mark the class as a candidate for component scanning
@RequestMapping("/design")  //Map web requests to specific methods in a controller class
@SessionAttributes("order")
@AllArgsConstructor
public class DesignTacoController {

  private final IngredientRepository ingredientRepo;

  private TacoRepository designRepo;

  /*
   * Needed to add a Taco object to the model
   *  This to add consistency to the form, so it'll work on a 'Taco' object, instead of 'design'
   *  It'll create this new Taco instance on every http request
   */
  @ModelAttribute(name = "taco")
  public Taco taco() {
    return new Taco();
  }
 
  /* @GetMapping Specifies that when an HTTP GET request is received for the page specified
  * in the @RequestMapping, the following method will be called to handle the request
  */
  // Model is an object that ferries data between a controller and whatever view is charged with rendering that data
  @GetMapping
  public String showDesignForm(Model model) {
    List<Ingredient> ingredients = new ArrayList<>();
    ingredientRepo.findAll().forEach(i -> ingredients.add(i));

    //Used to iterate through / display every value of an enum
    Type[] types = Ingredient.Type.values();
    for(Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
                         filterByType(ingredients, type));
    }

    log.info("Model attributes: {}", model.asMap());
    //the logical name of the view that will be used to render the model to the browser
    return "design";
  }

  //TODO: process POST request
  @PostMapping
  public String processDesign(@Valid @ModelAttribute("design") Taco design,
                              Errors errors, Model model) {
      if(errors.hasErrors()) {
        log.info("Errors object, in ErrorIF: " + errors.getAllErrors());
        return "design";
      }

      // Save taco design later...
      log.info("Processing design: " + design);
      
      return "redirect:/orders/current";
  }

  private List<Ingredient> filterByType(List<Ingredient> ingredients,
                                        Type type) {
      return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }

}
