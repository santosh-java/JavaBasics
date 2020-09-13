package com.cisco.preparation.javabasics;

import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.
 * <p>
 * Examples:
 * <p>
 * For any array, rightmost element always has next greater element as -1.
 * For an array which is sorted in decreasing order, all elements have next greater element as -1.
 * For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 * Element       NGE
 * 4      -->   5
 * 5      -->   25
 * 2      -->   25
 * 25     -->   -1
 * For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.
 * Element        NGE
 * 13      -->    -1
 * 7       -->     12
 * 6       -->     12
 * 12      -->     -1
 */
public class NextGreatestElement {
  public static void main(String[] args) {
    int[] arr = new int[]{4, 5, 2, 25};
    int[] arr1 = new int[]{13, 7, 6, 12};
    NextGreatestElement nge = new NextGreatestElement();
    System.out.println("NGE using nested loop");
    nge.printNGE(arr);
    nge.printNGE(arr1);
    System.out.println("NGE using Stack");
    nge.printNGEStack(arr);
    nge.printNGEStack(arr1);
  }

  public void printNGE(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int nge = -1;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] < arr[j]) {
          nge = arr[j];
          break;
        }
      }
      System.out.println("NGE of " + arr[i] + " -- " + nge);
    }
  }

  public void printNGEStack(int[] arr) {
    if (arr.length <= 0)
      return;

    Stack<Integer> stack = new Stack<>();
    stack.push(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      int next = arr[i];

      if (!stack.empty()) {
        // if stack is not empty, then
        // pop an element from stack
        int elem = stack.pop();

        /* If the popped element is smaller than
          next, then a) print the pair b) keep
          popping while elements are smaller and
          stack is not empty */
        while (elem < next) {
          System.out.println("NGE of " + elem + " -- " + next);
          if (stack.empty())
            break;
          elem = stack.pop();
        }
        // If popped element is greater than next, then the element back
        if (elem > next) {
          stack.push(elem);
        }
      }
      // Push the next to the stack so that we can find NGE for it
      stack.push(next);
    }

    /* After looping through the array, the remaining elements in the
    stack does not have a NGE. So print NGE for them as -1
     */
    while (!stack.empty()) {
      System.out.println("NGE of " + stack.pop() + " -- " + -1);
    }
  }
}
