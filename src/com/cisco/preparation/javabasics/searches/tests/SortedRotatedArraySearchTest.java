package com.cisco.preparation.javabasics.searches.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cisco.preparation.javabasics.searches.SortedRotatedArraySearch;

import org.junit.jupiter.api.Test;

public class SortedRotatedArraySearchTest {
  SortedRotatedArraySearch searcher = new SortedRotatedArraySearch();

  @Test
  public void shouldSucceedInSearchingRotatedArray() {
    int[] arr = {11, 13, 15, 17, 5, 7, 9};
    assertTrue(searcher.sortedRotatedArraySearch(arr, 15) == 2);
    assertTrue(searcher.sortedRotatedArraySearch(arr, 9) == 6);
  }

  @Test
  public void shouldNotFindElementNotAvailableSearchingRotatedArray() {
    int[] arr = {15, 17, 5, 7, 9, 11, 13};
    assertTrue(searcher.sortedRotatedArraySearch(arr, 12) == -1);
  }

  @Test
  public void shouldNotFindElementNotAvailableSearchingNullArray() {
    assertTrue(searcher.sortedRotatedArraySearch(null, 12) == -1);
  }
}
