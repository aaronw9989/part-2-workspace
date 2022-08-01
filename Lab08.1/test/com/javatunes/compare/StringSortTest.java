/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class StringSortTest {

  private List<String> names = Arrays.asList("Jason", "Martin", "Jack", "Mary", "Jill", "Frederick",
      "Laurie", "Ed");

  @Test
  public void testStringListSort() {
    System.out.println("Order will be added to following list:");
    System.out.println(names + "\n");

    System.out.println("Natural order:");
    names.sort(null);
    System.out.println(names + "\n");

    System.out.println("Increasing length - Comparator class:");
    names.sort(new StringLengthComparator());
    System.out.println(names + "\n");

    System.out.println("Increasing length - lambda:");
    // TODO: call names.sort() and pass in an "expression" lambda
    // hint: a compatible lambda will have this form:
    //       (obj1, obj2) -> expression-that-evaluates-to-int
    // names.sort((a, b) -> a.length() - b.length());


    names.sort((a, b) -> a.length() - b.length());

    System.out.println(names);

    names.sort((a, b) -> {
      if (a.length() < b.length()) {
        return -1;
      } else if (a.length() > b.length()) {
        return 1;
      } else {
        return 0;
      }
    });

    // Method reference lambda
    names.sort(Comparator.comparing(String::length));

  }
}