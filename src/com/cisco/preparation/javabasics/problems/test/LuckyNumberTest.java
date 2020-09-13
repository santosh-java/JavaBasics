package com.cisco.preparation.javabasics.problems.test;

import static org.junit.jupiter.api.Assertions.*;

import com.cisco.preparation.javabasics.problems.LuckyNumber;

import org.junit.jupiter.api.Test;

public class LuckyNumberTest {
  private LuckyNumber ln = new LuckyNumber();

  @Test
  public void luckyNumber13Test() {
    assertTrue(ln.isLucky(13));
  }

  @Test
  public void luckyNumber7Test() {
    assertTrue(ln.isLucky(7));
  }

  @Test
  public void luckyNumber5Test() {
    assertFalse(ln.isLucky(5));
  }
}
