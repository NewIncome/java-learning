package com.jalfredev.taco_cloud.data;

import com.jalfredev.taco_cloud.Taco;

public interface TacoRepository {  /* Interface||CONTRACT for Taco dataPersistence */

  /*
   * Saving a taco design requires that you save essential taco design
   * details and also save the ingredients associated with that taco
   * to the Taco_Ingredients table
   */
  Taco save(Taco design);  
  
}
