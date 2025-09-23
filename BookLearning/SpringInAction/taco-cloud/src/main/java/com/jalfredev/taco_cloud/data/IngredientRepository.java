package com.jalfredev.taco_cloud.data;

import com.jalfredev.taco_cloud.Ingredient;

public interface IngredientRepository {
  
  /* the method will return an object that you can iterate over,
   * and each item in the sequence will be an Ingredient */
  Iterable<Ingredient> findAll();

  Ingredient findOne(String id);

  Ingredient save(Ingredient ingredient);

}
