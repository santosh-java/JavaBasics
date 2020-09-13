package com.cisco.preparation.javabasics.bitwiseOps;

/**
 * Problem: Given a number and pos1 and pos2, swap the bits occurring at pos1 and pos2 positions in the give number
 * Solution: This can be done in O(1) time complexity using Bitwise operations. Logic can be as below:
 * <p>
 * 1. Since bits can take only 1 or 0, swapping essentially means changing the value from 1 to 0 or 0 to 1
 * 2. If both the bits at pos1 and pos2 are same no change will occur. So return the number itself
 * 3. If the bits are different, then we need to switch the bits. This can be done by some bit shifting and bit masking.
 * 3.1. Find the bit mask to be used to do XOR with the number by
 * bitMask = (1L << pos1) | (1L << pos2)
 * 3.2. Now result is number ^ bitMask
 * <p>
 * The result number after XOR with bitMask will have the bits in that position swapped
 */
public class SwapBitsOfNumber {
  public long swapBitPositionsOfNumber(long number, int pos1, int pos2) {
    if (((number >> pos1) & 1) != ((number >> pos2) & 1)) {
      long bitMask = (1L << pos1) | (1L << pos2);
      return number ^ bitMask;
    }
    return number;
  }
}
