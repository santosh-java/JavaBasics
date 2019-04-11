package com.oracle.practice.programming;

public class LargestSumContiguousArray {
	public static void main(String[] args) {
		LargestSumContiguousArray lsca = new LargestSumContiguousArray();
		System.out.println(lsca.maxSumSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		System.out.println(lsca.maxSumSubArray(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }));
		System.out.println(lsca.maxSumSubArray(new int[] { -2, -3, 4, -1, -2, -1, -5, -3 }));
		System.out.println(lsca.maxSumSubArray(new int[] { 2, 3, 4, 1, 2, 1, 5, 3 }));
		System.out.println(lsca.maxSumSubArray(new int[] { -2, -5, 6, -2, -3, 1, 5, -6 }));
		String s = "aeiou";
		System.out.println(s.contains("a"));

	}

	public int maxSumSubArray(int[] arr) {
		int sum = arr[0];
		int result = arr[0];
		int start = -1;
		int end = -1;
		for (int i = 1; i < arr.length; i++) {
			if (sum <= 0) {
				sum = arr[i];
			} else {
				sum += arr[i];
			}
			if (result < sum) {
				result = sum;
				if (start > -1) {
					end = i;
				} else
					start = i;
			}
		}

		System.out.println("Start :" + start + " End : " + end);

		return result;
	}
}
