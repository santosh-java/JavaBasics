package com.cisco.preparation.javabasics.problems;

/**
 * Given an array of integers, and an index in the array, say pivotIndex, write a program to segregate all the elements of the array such a way that all the elements
 * less than or equal to the element at pivotIndex to the left of the pivot element, and all the elements greater than element at pivotIndex to the right.
 * <p>
 * Goal is to achieve this with as less complexity as possible. i.e. O(n) time and O(1) space
 */
public class DutchFlagProblem {
  public int[] dutchFlagSorting(int[] arr, int pivotIndex) {
    if (arr == null || arr.length == 0) {
      return null;
    }

    if (pivotIndex < 0 || pivotIndex >= arr.length) {
      return null;
    }

    if (arr.length == 1) {
      return arr;
    }

    int pivotElem = arr[pivotIndex];
    int stIndex = 0;
    int enIndex = arr.length - 1;

    System.out.println("Initial Array and pivotElem [" + pivotElem + "]");
    displayArray(arr);

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < pivotElem) {
        int temp = arr[i];
        arr[i] = arr[stIndex];
        arr[stIndex] = temp;
        stIndex++;
      }
    }
    System.out.println("Array after moving all < elements than pivotElem [" + pivotElem + "]");
    displayArray(arr);

    for (int i = arr.length-1; i >=0; i--) {
      if (arr[i] > pivotElem) {
        int temp = arr[i];
        arr[i] = arr[enIndex];
        arr[enIndex] = temp;
        enIndex--;
      }
    }
    System.out.println("Array after moving all > elements than pivotElem [" + pivotElem + "]");
    displayArray(arr);
    return arr;
  }

  private void displayArray(int[] arr) {
    for (int elem : arr) {
      System.out.print(" " + elem);
    }
    System.out.println("");
  }
}
