package com.oracle.practice.programming.sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		ShellSort ss = new ShellSort();
		int[] arr = new int[] { 4, 5, 6, 2, 1, 7, 10, 3, 8, 9 };
		ss.shellSort(arr);
		System.out.println("Final sorted array using Shell sort is::");
		Arrays.stream(arr).forEach(System.out::print);
	}

	public void shellSort(int[] arr) {
		int increment = arr.length / 2;

		while (increment >= 1) {
			for (int startIndex = 0; startIndex < increment; startIndex++) {
				insertionSort(arr, startIndex, increment);
			}
			increment /= 2;
		}
	}

	public void insertionSort(int[] arr, int startIndex, int increment) {
		for (int i = startIndex; i < arr.length; i += increment) {
			for (int j = Math.min(i + increment, arr.length - 1); j-increment >= 0; j -= increment) {
				if (arr[j] < arr[j - increment]) {
					// Swap the elements
					arr[j] = arr[j] + arr[j - increment];
					arr[j - increment] = arr[j] - arr[j - increment];
					arr[j] = arr[j] - arr[j - increment];
				} else {
					break;
				}
			}
		}
	}
}
