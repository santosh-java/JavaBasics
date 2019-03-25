package com.oracle.practice.programming.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		int[] arr = new int[] { 4, 5, 6, 2, 1, 7, 10, 3, 8, 9 };
		Arrays.stream(ss.selectionSort(arr)).forEach(System.out::print);
	}

	public int[] selectionSort(int[] unsortedInts) {
		int count = 0;
		for (int i = 0; i < unsortedInts.length; i++) {
			for (int j = i + 1; j < unsortedInts.length; j++) {
				if (unsortedInts[i] > unsortedInts[j]) {
					// Swap elements in i and j positions in the array
					unsortedInts[i] = unsortedInts[i] + unsortedInts[j];
					unsortedInts[j] = unsortedInts[i] - unsortedInts[j];
					unsortedInts[i] = unsortedInts[i] - unsortedInts[j];
					System.out.print("Array after " + ++count + "th iteration... :: ");
					Arrays.stream(unsortedInts).forEach(System.out::print);
					System.out.println("\n");
				}
			}
		}
		return unsortedInts;
	}
}
