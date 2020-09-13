package com.cisco.preparation.javabasics.bitwiseOps;

/**
 * Problem :
 * Find the count of bits set to 1 in a provided integer.
 *
 * Iterative Solution:
 *  Iterate until the integer is 0 and do bitwise-AND of integer with 1 and check if the result of that operation is 1 or 0.
 *  If the result of the op is 1 then the bit in that position is 1 and hence increment the count by 1. Else continue
 *  Now right shift integer by 1 and continue the loop until integer value is > 0
 *
 *  Time complexity of this solution is O(n) where n is the number of bits in the integer.
 *
 * A better solution can be obtained using second solution which is as below:
 *  This solution involves four operations.
 *  1. bitwise NOT of the (number - 1) say nN_1
 *  2. number bitwise-AND of number and nN_1 i.e. (number & nN_1) say rightMost1BitAsInteger
 *  3. bitwise XOR of number and rightMost1BitAsInteger
 *  4. increment the count by 1
 *  Continue the loop until the number is > 0;
 *
 *  The logic behind this solution is to find only the bits that are set to 1 from the right most side (steps 1 & 2) and
 *  do an XOR with the number (which will unset the right most bit and sets its value to 0) and assign it to number. Keep
 *  counting the number of iterations the while loop runs.
 *  And repeat these steps until number is 0 and the count variable will hold the number of 1 bits in the provided integer.
 *
 *  Time complexity of this solution will be O(s) where s is the number of bits set to 1 in the provided number
 *
 */
public class FindNumberOf1BitsInInteger {
  public int count1BitsInInteger(int number) {
    int count = 0;

    while (number > 0) {
      int n_num_1 = ~(number - 1);
      int x = number & n_num_1;
      number = number ^ x;
      count++;
    }

    return count;
  }
}
