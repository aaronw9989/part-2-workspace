package com.javatunes.personnel;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class AllTests {

  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(HourlyEmployeeTest.class, SalariedEmployeeTest.class);

    System.out.println("===============");
    System.out.println("TEST RESULT");
    System.out.println("===============");
    System.out.println("All test passed: " + result.wasSuccessful());
    System.out.println("Total tests run: " + result.getRunCount());
    System.out.println("Failure count: " + result.getFailureCount());

  }

}
