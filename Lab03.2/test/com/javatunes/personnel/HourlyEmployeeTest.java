package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class HourlyEmployeeTest {

  private HourlyEmployee employee;

  @Before
  public void setUp() throws Exception {
    employee = new HourlyEmployee("John Smith", new Date(0), 50.0, 40.0);
  }

  @Test
  public void pay() {
  }

  @Test
  public void payTaxes() {
  }

  @Test
  public void equals() {
    HourlyEmployee other = new HourlyEmployee("John Smith", new Date(0), 50.0, 40.0);
    assertTrue(employee.equals(other));

  }

  @Test
  public void testHashCode() {
    HourlyEmployee other = new HourlyEmployee("John Smith", new Date(0), 50.0, 40.0);

//    assertEquals(employee.hashCode(), other.hashCode());

    assertEquals(employee.hashCode(),
        (Objects.hash(
            Objects.hash(other.getName(), other.getHireDate()),
            other.getRate(),
            other.getHours())));
  }
}