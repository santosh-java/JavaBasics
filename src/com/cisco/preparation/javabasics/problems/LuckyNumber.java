package com.cisco.preparation.javabasics.problems;

/**
 * Find out if a given number is a Lucky Number or not.
 * <p>
 * Lucky Number: Let us understand what is Lucky Number using an example:
 * Say, we need to check if 7 is lucky number or not. So the process to find if a number is lucky or not is:
 * take all the numbers from 1 till n, i.e. in this example, [1,2,3,4,5,6,7]
 * Now take a counter with value 2. And cancel out all the numbers in the above array that lie in the counter'th position
 * i.e. 2nd position.
 * Array after cancelling all 2nd elements : [1,3,5,7]
 * Now increment counter by 1. So counter is now 3. Repeat the cancellation process on the new array.
 * So Array after cancelling all 3rd elements: [1,3,7]
 * Now increment counter by 1. So counter is now 4. But there is no 4th element in the new array. So the process stops and
 * if the number is still present, then the number is Lucky number. Since 7 is still present in the final array, it
 * is considered Lucky Number.
 */
public class LuckyNumber {
  public boolean isLucky(int n) {
    return findIfLucky(n, 2);
  }

  private boolean findIfLucky(int num, int counter) {
    if (num % counter == 0) { //Base condition where the number is cancelled by the counter. So Number is Not Lucky
      return false;
    }

    if (num < counter) { // Base condition where number is left because counter is greater than the number. So Number is Lucky
      return true;
    }

    num = num - num / counter++;
    return findIfLucky(num, counter);
  }
}
