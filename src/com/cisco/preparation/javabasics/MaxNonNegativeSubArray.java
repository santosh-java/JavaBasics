package com.cisco.preparation.javabasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find out the maximum sub-array of non negative numbers from an array. The
 * sub-array should be continuous. That is, a sub-array created by choosing the
 * second and fourth element and skipping the third element is invalid.
 * 
 * Maximum sub-array is defined in terms of the sum of the elements in the
 * sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 * 
 * Example:
 * 
 * A : [1, 2, 5, -7, 2, 3] The two sub-arrays are [1, 2, 5] [2, 3]. The answer
 * is [1, 2, 5] as its sum is larger than [2, 3]
 * 
 * NOTE: If there is a tie, then compare with segment's length and return
 * segment which has maximum length NOTE 2: If there is still a tie, then return
 * the segment with minimum starting index
 * 
 * @author MSantoshGiriGovind
 *
 */
public class MaxNonNegativeSubArray {
	public static void main(String[] args) {
//		int[] a = { 336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011,
//				-1131176229, -859484421 };
		int[] a = {756898537, -1973594324, -2038664370, -184803526, 1424268980};

		// printArray(MaxSubArray(a));
		printArrayList(MaxSubArray(getListFromArray(a)));
	}

	private static ArrayList<Integer> getListFromArray(int[] a) {
		ArrayList<Integer> result = new ArrayList<>(a.length);
		for (int i = 0; i < a.length; i++) {
			result.add(a[i]);
		}
		return result;
	}

	private static void printArrayList(ArrayList<Integer> maxSubArray) {
		System.out.print("[");
		for (int i = 0; i < maxSubArray.size(); i++) {
			System.out.print(maxSubArray.get(i) + ",");
		}
		System.out.print("]");
	}

	private static void printArray(int[] maxSubArray) {
		System.out.print("[");
		for (int i = 0; i < maxSubArray.length; i++) {
			System.out.print(maxSubArray[i] + ",");
		}
		System.out.print("]");
	}

	private static ArrayList<Integer> MaxSubArray(ArrayList<Integer> a) {
		List<SubArrData> lst = new ArrayList<>();
		int startIndex = 0;
		long currSumOfSubArr = 0;
		int currSubArrLenght = 0;
		for (int i = 0; i < a.size(); i++) {
			int valI = a.get(i);
			if (valI < 0) {
				if (startIndex <= startIndex + currSubArrLenght - 1) {
					SubArrData s = new SubArrData(startIndex, currSubArrLenght, currSumOfSubArr);
					lst.add(s);
					currSumOfSubArr = 0;
					startIndex = i + 1;
					currSubArrLenght = 0;
				} else {
					startIndex = i + 1;
					continue;
				}
			} else {
				currSumOfSubArr += valI;
				currSubArrLenght++;
				if(i==a.size()-1)
				{
					SubArrData s = new SubArrData(startIndex, currSubArrLenght, currSumOfSubArr);
					lst.add(s);
				}
			}
		}

		if (lst.size() > 0) {
			Collections.sort(lst);
			SubArrData maxSubArr = lst.get(0);
			return maxSubArrAsList(a, maxSubArr);
		} else
			return new ArrayList<>();
	}

	private static ArrayList<Integer> maxSubArrAsList(ArrayList<Integer> a, SubArrData maxSubArr) {
		ArrayList<Integer> result = new ArrayList<>(maxSubArr.getLength());

		for (int i = maxSubArr.getStartIndex(); i < maxSubArr.getStartIndex() + maxSubArr.getLength(); i++) {
			result.add(a.get(i));
		}
		return result;
	}
}

class SubArrData implements Comparable<SubArrData> {
	private int startIndex;
	private int length;
	private long sum;

	public SubArrData(int startIndex, int lenght, long sum) {
		this.startIndex = startIndex;
		this.length = lenght;
		this.sum = sum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public int getLength() {
		return length;
	}

	public long getSum() {
		return sum;
	}

	@Override
	public int compareTo(SubArrData o) {
		int result = 0;
		if (o.sum > sum) {
			result = 1;
		} else if (o.sum < sum) {
			result = -1;
		}
		if (result == 0) {
			result = o.length - length;
		} else {
			return result;
		}
		if (result == 0) {
			result = o.startIndex - startIndex;
		}

		return result;
	}
}
