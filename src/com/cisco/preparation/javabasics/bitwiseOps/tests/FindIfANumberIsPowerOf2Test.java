package com.cisco.preparation.javabasics.bitwiseOps.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cisco.preparation.javabasics.bitwiseOps.FindIfANumberIsPowerOf2;

import org.junit.jupiter.api.Test;

public class FindIfANumberIsPowerOf2Test {
  @Test
  public void shouldSucceedForPowerOf2Values(){
    FindIfANumberIsPowerOf2 f = new FindIfANumberIsPowerOf2();
    assertTrue(f.checkIfGivenNumberIsPowerOfTwo(16));
    assertTrue(f.checkIfGivenNumberIsPowerOfTwo(64));
    assertTrue(f.checkIfGivenNumberIsPowerOfTwo(128));
    assertTrue(f.checkIfGivenNumberIsPowerOfTwo(512));
  }

  @Test
  public void shouldFailForNonPowerOf2Values(){
    FindIfANumberIsPowerOf2 f = new FindIfANumberIsPowerOf2();
    assertTrue(!f.checkIfGivenNumberIsPowerOfTwo(17));
    assertTrue(!f.checkIfGivenNumberIsPowerOfTwo(219));
    assertTrue(!f.checkIfGivenNumberIsPowerOfTwo(100));
    assertTrue(!f.checkIfGivenNumberIsPowerOfTwo(9));
  }
}
