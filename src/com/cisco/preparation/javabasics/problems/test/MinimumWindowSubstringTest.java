package com.cisco.preparation.javabasics.problems.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cisco.preparation.javabasics.problems.MinimumWindowSubstring;

import org.junit.jupiter.api.Test;

public class MinimumWindowSubstringTest {
  private MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

  @Test
  public void test1() {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    assertTrue("BANC".equals(minimumWindowSubstring.minimumWindow(s, t)));
  }

  @Test
  public void test2() {
    String s = "AA";
    String t = "AA";
    assertTrue("AA".equals(minimumWindowSubstring.minimumWindow(s, t)));
  }

  @Test
  public void test3() {
    String s = "cabwefgewcwaefgcf";
    String t = "cae";
    assertTrue("cwae".equals(minimumWindowSubstring.minimumWindow(s, t)));
  }
}
