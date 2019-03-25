package com.oracle.practice.programming.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort bs = new InsertionSort();
		int[] arr = new int[] { 4, 5, 6, 2, 1, 7, 10, 3, 8, 9 };
		bs.insertionSort(arr);
		System.out.println("Finally sorted array using Insertion sort ::");
		Arrays.stream(arr).forEach(System.out::print);
	}

	public void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					// swap the elements
					arr[j] = arr[j] + arr[j - 1];
					arr[j - 1] = arr[j] - arr[j - 1];
					arr[j] = arr[j] - arr[j - 1];
				} else {
					// Since the sorted array is in assending order and the new element is not less
					// than the last element in the sorted array, there is no need to compare with
					// the remaining lesser elements in the sorted array. 
					break;
				}
				Arrays.stream(arr).forEach(System.out::print);
				System.out.println("\n");
			}
		}
	}

}
