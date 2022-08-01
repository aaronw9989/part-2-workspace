/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

public abstract class Product {

  // NOTE: We use an abstract class here because interface can NOT have any instance state
  private String code;

  public Product(String code) {
    this.code = code;
  }
  
  public String getCode() {
    return code;
  }
  
  public abstract Double getPrice();
  
  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" + getCode() + ")";
  }
}