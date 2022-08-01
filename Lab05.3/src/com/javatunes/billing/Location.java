/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

// Remember an Enum is just a class, but the compiler helps us fill in the details
// Enum extends
public enum Location {

  // NOTE: These fields are all subclasses of Location
  // NOTE: All three of these are static final instances

  // Subclass of Location called USA
  // USA extends Location
  // USA has a nested class USATax
  USA {
    @Override
    public TaxCalculator getTaxCalculator() {
      return new USATax();
    }
  },
  EUROPE {
    @Override
    public TaxCalculator getTaxCalculator() {
      return new EuropeTax();
    }
  },
  ONLINE {
    @Override
    public TaxCalculator getTaxCalculator() {
      return new OnlineTax();
    }
  };

  public abstract TaxCalculator getTaxCalculator();



}