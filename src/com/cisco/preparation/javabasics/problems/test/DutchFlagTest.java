package com.cisco.preparation.javabasics.problems.test;

import com.cisco.preparation.javabasics.problems.DutchFlagProblem;

import org.junit.jupiter.api.Test;

public class DutchFlagTest {
  DutchFlagProblem d = new DutchFlagProblem();

  @Test
  public void ascendingArrTest() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int pI = 5;
    int[] resultArr = d.dutchFlagSorting(arr, pI);
    System.out.println("Original Array : ");
    displayArray(arr);
    System.out.println("Rearranged Array : " + resultArr);
    displayArray(resultArr);
  }

  @Test
  public void descendingArrTest() {
    int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int pI = 5;
    int[] resultArr = d.dutchFlagSorting(arr, pI);
    System.out.println("Original Array : ");
    displayArray(arr);
    System.out.println("Rearranged Array : ");
    displayArray(resultArr);
  }

  @Test
  public void randomArrTest() {
    int[] arr = {3, 15, 11, 17, 11, 12, 14, 10, 8};
    int pI = 4;
    int[] resultArr = d.dutchFlagSorting(arr, pI);
    System.out.println("Original Array : ");
    displayArray(arr);
    System.out.println("Rearranged Array : ");
    displayArray(resultArr);
  }

  private void displayArray(int[] arr) {
    for (int elem : arr) {
      System.out.print(" " + elem);
    }
    System.out.println("");
  }
}
