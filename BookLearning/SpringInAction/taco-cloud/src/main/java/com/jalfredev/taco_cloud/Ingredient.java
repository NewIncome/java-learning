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

  public static enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
}
