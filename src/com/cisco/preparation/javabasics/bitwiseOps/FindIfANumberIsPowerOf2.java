package com.cisco.preparation.javabasics.bitwiseOps;

/**
 * Find if a given number is power of 2 or not.
 * <p>
 * For this solution we know the fact that if a number is power of 2, then the binary representation of that number will contain
 * only one bit set to 1 and all others are 0s.
 * <p>
 * We use this fact and find if a number is power of 2 or not. So to solve this, we need to count the number of bits set in the
 * number to 1 and if the count is equal to 1 then it is a power of 2 otherwise not.
 * <p>
 * To find the number of bits set to 1, we use the below logic:
 * <p>
 * 1. set count = 0
 * 2. Repeat below steps until number is > 0
 * 2.1. Nn_1 = bitwiseNot of (number-1)
 * 2.2. number = number bitwiseAND Nn_1
 * 2.3. count++
 * 3. Return count
 * <p>
 * Solution:
 * 1. Find the count of bits set to 1 in the given number using above algorithm and set it to count
 * 2. if count ==1 then number is power of 2 otherwise number is not power of 2
 */
public class FindIfANumberIsPowerOf2 {
  private int countNumberOf1BitsInNumber(int number) {
    int count = 0;
    while (number > 0) {
      number = number ^ (number & -number);
      count++;
    }
    return count;
  }

  public boolean checkIfGivenNumberIsPowerOfTwo(int number) {
    return countNumberOf1BitsInNumber(number) == 1;
  }
}
