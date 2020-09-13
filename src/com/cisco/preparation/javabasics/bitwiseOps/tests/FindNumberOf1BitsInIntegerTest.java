package com.cisco.preparation.javabasics.bitwiseOps.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cisco.preparation.javabasics.bitwiseOps.FindNumberOf1BitsInInteger;

import org.junit.jupiter.api.Test;

public class FindNumberOf1BitsInIntegerTest {
  @Test
  public void count1BitsInIntegerTest1() {
    FindNumberOf1BitsInInteger fi = new FindNumberOf1BitsInInteger();
    int countOfSetBits = fi.count1BitsInInteger(209);
    assertTrue(countOfSetBits == 4);
  }

  @Test
  public void count1BitsInIntegerTest2() {
    FindNumberOf1BitsInInteger fi = new FindNumberOf1BitsInInteger();
    int countOfSetBits = fi.count1BitsInInteger(203);
    assertTrue(countOfSetBits == 5);
  }
}
