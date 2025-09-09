package com.jalfredev.taco_cloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/*
 * Data: automatically generates
 *  • Getters for all private fields
 *  • Setters for all non-final fields (these will be set in the constructor)
 *  • toString() that provides string representation of the object details
 *  • equals() and hashCode() methods
 * RequiredArgsConstructor:
 *  • 
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
  private final String id;
  private final String name;
  private final Type type;

  /* enum named Type behind the scenes creates a class for each object
   * inside the enum, that's why you can call them Ingredient.WRAP,
   * since it's static
  */
  public static enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
}
