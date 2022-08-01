package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

  public static final int INITIAL_VOLUME = 50;
  private Television television;


  @Before
  public void setUp() throws Exception {
    television = new Television("Sony", INITIAL_VOLUME, DisplayType.OLED);
  }

  @Test
  public void getBrand() {
    fail("Not yet implemented");
  }

  @Test
  public void setBrand() {
  }

  @Test
  public void getVolume() {
    assertEquals(INITIAL_VOLUME, television.getVolume());
  }

  @Test
  public void setVolume_valid() {
    television.setVolume(Television.MIN_VOLUME + 1);
    assertEquals(Television.MIN_VOLUME + 1, television.getVolume());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setVolume_invalid() {
    television.setVolume(Television.MIN_VOLUME - 1);
  }

  @Test
  public void getCurrentChannel() {
  }

  @Test
  public void changeChannel() {
  }

  @Test
  public void getDisplay() {
  }

  @Test
  public void setDisplay() {
  }

  @Test
  public void compareTo() {
  }

  @Test
  public void testHashCode() {
  }

  @Test
  public void testEquals() {
  }
}