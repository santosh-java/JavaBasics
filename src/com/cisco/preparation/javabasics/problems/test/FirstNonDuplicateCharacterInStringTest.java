package com.cisco.preparation.javabasics.problems.test;

import static org.junit.Assert.*;

import com.cisco.preparation.javabasics.problems.FirstNonDuplicateCharacterInString;

import org.junit.Test;

public class FirstNonDuplicateCharacterInStringTest {
  FirstNonDuplicateCharacterInString finder = new FirstNonDuplicateCharacterInString();

  @Test
  public void test1() {
    String str = "efficiency";
    Character c = finder.findFirstNonDuplicateChar(str);
    assertNotNull(c);
    assertEquals(Character.toString('n'), c.toString());
  }
}
