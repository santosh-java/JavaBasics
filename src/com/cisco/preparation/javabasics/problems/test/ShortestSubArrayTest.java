package com.cisco.preparation.javabasics.problems.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cisco.preparation.javabasics.problems.ShortestSubArray;

import org.junit.jupiter.api.Test;

public class ShortestSubArrayTest {
  private ShortestSubArray ssa = new ShortestSubArray();

  @Test
  public void test1() {
    String str = "xyyzyzyx";
    char[] arr = {'x', 'y', 'z'};
    assertTrue("zyx".equals(ssa.getShortestUniqueSubstring(arr, str)));
  }

  @Test
  public void test2() {
    String str = "xyyxyzyxayxsyaxusyayzyws";
    char[] arr = {'x', 'y', 'z'};
    assertTrue("xyz".equals(ssa.getShortestUniqueSubstring(arr, str)));
  }

  @Test
  public void test3() {
    String str = "ADOBECODEBANC";
    char[] arr = {'A', 'B', 'C'};
    assertTrue("BANC".equals(ssa.getShortestUniqueSubstring(arr, str)));
  }

  @Test
  public void test4() {
    String str = "AA";
    char[] arr = {'A'};
    assertTrue("A".equals(ssa.getShortestUniqueSubstring(arr, str)));
  }

  @Test
  public void testMinWindow1() {
    String str = "xyyxyzyxayxsyaxusyayzyws";
    String arr = "xyz";
    assertTrue("xyz".equals(ssa.minimumWindow(arr, str)));
  }

  @Test
  public void testMinWindow2() {
    String str = "xyyzyzyx";
    String arr = "xyz";
    assertTrue("zyx".equals(ssa.minimumWindow(arr, str)));
  }

  @Test
  public void testMinWindow3() {
    String str = "ADOBECODEBANC";
    String arr = "ABC";
    assertTrue("BANC".equals(ssa.minimumWindow(arr, str)));
  }

  @Test
  public void testMinWindow4() {
    String str = "AA";
    String arr = "A";
    assertTrue("A".equals(ssa.minimumWindow(arr, str)));
  }
}
