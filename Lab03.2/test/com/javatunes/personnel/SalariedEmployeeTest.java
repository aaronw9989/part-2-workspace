package com.javatunes.personnel;

import static org.junit.Assert.*;

import gov.irs.TaxPayer;
import java.sql.Date;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class SalariedEmployeeTest {

  private SalariedEmployee employee;

  @Before
  public void setUp() throws Exception {
    employee = new SalariedEmployee("John Smith", new Date(0), 1000.0);
  }

  @Test
  public void pay() {
    assertEquals(1000.0, employee.pay(), .005);
  }

  @Test
  public void payTaxes() {
    assertEquals(1000.0 * TaxPayer.SALARIED_TAX_RATE, employee.payTaxes(), .005);
  }

  @Test
  public void equals() {
    SalariedEmployee other = new SalariedEmployee("John Smith", new Date(0), 1000.0);

    assertTrue(employee.equals(other));

  }

  @Test
  public void testHashCode_same() {

    SalariedEmployee other = new SalariedEmployee("John Smith", new Date(0), 1000.0);

    assertEquals(employee.hashCode(),
        (Objects.hash(
            Objects.hash(other.getName(), other.getHireDate()),
            other.pay())));
  }

  @Test
  public void testHashCode_different() {
    SalariedEmployee other = new SalariedEmployee("John Smith", new Date(1), 1000.0);
    assertNotEquals(employee, other);
  }
}