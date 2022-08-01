/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.Collection;

public class Order {
  private String id;
  
  public Order(String id) {
    this.id = id;
  }
  
  /**
   * TODO:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */

  // <? extends Product> - I want something that extends product
  public void processCart(ShoppingCart<? extends Product> cart) {

    String header = "-".repeat(32);
    System.out.println(header);
    for (Product item : cart.allItems()) {
      System.out.println(item.getCode());
    }
  }
  
  public String getId() {
    return id;
  }
}