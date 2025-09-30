package com.jalfredev.taco_cloud.data;

import com.jalfredev.taco_cloud.Order;

public interface OrderRepository {  /* Interface||CONTRACT for Order dataPersistence */

  /*
   * Saving an order requires that you also save the tacos associated
   * with the order to the Taco_Order_Tacos table
   */
  Order save(Order order);
  
}
