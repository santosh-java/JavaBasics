package com.cisco.preparation.javabasics.bitwiseOps.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cisco.preparation.javabasics.bitwiseOps.SwapBitsOfNumber;

import org.junit.jupiter.api.Test;

public class SwapBitsOfNumberTest {
  @Test
  public void swapBitsOfNumberTest1() {
    SwapBitsOfNumber s = new SwapBitsOfNumber();
    long bitsSwappedNumber = s.swapBitPositionsOfNumber(229L, 3, 5);
    assertTrue(bitsSwappedNumber == 205);
  }

  @Test
  public void swapBitsOfNumberTest2() {
    SwapBitsOfNumber s = new SwapBitsOfNumber();
    long bitsSwappedNumber = s.swapBitPositionsOfNumber(229L, 1, 2);
    assertTrue(bitsSwappedNumber == 227);
  }

  @Test
  public void swapBitsOfNumberTest3() {
    SwapBitsOfNumber s = new SwapBitsOfNumber();
    long bitsSwappedNumber = s.swapBitPositionsOfNumber(229L, 1, 3);
    assertTrue(bitsSwappedNumber == 229);
  }
}
