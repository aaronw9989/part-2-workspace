/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;
// Static import wants to bring in all static members of the class, without having
// to use the class name
import static org.junit.Assert.*;
// Bring the word test into the compilers' namespace for annotation
import org.junit.Test;

public class CalculatorTest {

  // Uses reflection to test method
  @Test
  public void add() {
    System.out.println("Testing the add method");
    Calculator calc = new Calculator();
    assertEquals(5, calc.add(1, 4));  // expected, actual
  }

  @Test
  public void divide() {
    Calculator calc = new Calculator();
    // Double gives us accuracy problems.
    // Thus, this is deprecated, we need to add a tolerance
    assertEquals(2.5, calc.divide(5,2),0.00000001);
  }

  @Test
  public void isEven() {
    Calculator calc = new Calculator();
    assertTrue(calc.isEven(10));

  }
}