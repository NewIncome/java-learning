package com.jalfredev.taco_cloud;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {

  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")
  private String name;

  /* already taken care of in view, but used to add robustness */
  @NotNull(message="Ingredients cannot be null")
  @Size(min=1, message="You must choose at least 1 ingredient")
  private List <String> ingredients;
  
}
