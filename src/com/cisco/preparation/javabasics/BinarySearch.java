package com.cisco.preparation.javabasics;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		System.out.println(getPositionOfElemIfPresent(arr, 6));
	}

	private static int getPositionOfElemIfPresent(int[] arr, int find) {
		int start = 0;
		int end = arr.length;
		int mid = 0;
		do {
			mid = (start + end) / 2;
			if (mid >= arr.length)
				break;
			if(find == arr[mid])
				return mid;
			else if (find < arr[mid]) {
				end = mid - 1;
			} else if (find > arr[mid]) {
				start = mid+1;
			}
		} while (start <= end);
		return -1;
	}
}
