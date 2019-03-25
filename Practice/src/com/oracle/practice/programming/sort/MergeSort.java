package com.oracle.practice.programming.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 5, 6, 2, 1, 7, 10, 3, 8, 9 };
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr);
	}

	public void mergeSort(int[] arr) {
		if (arr.length == 1)
			return;

		int midIndex = arr.length / 2 + arr.length % 2;
		int[] arrFirstHalf = new int[midIndex];
		int[] arrSecondHalf = new int[arr.length - midIndex];
		split(arr, arrFirstHalf, arrSecondHalf);

		mergeSort(arrFirstHalf);
		mergeSort(arrSecondHalf);

		merge(arr, arrFirstHalf, arrSecondHalf);
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println("\n");
	}

	public void split(int[] arr, int[] firstHalf, int[] secondHalf) {
		int index = 0;
		int secondHalfStartIndex = firstHalf.length;

		for (int element : arr) {
			if (index < secondHalfStartIndex) {
				firstHalf[index] = element;
			} else {
				secondHalf[index - secondHalfStartIndex] = element;
			}
			index++;
		}
	}

	public void merge(int[] finalArray, int[] firstArr, int[] secondArr) {
		int firstIndex = 0;
		int secondIndex = 0;
		int index = 0;

		while (firstIndex < firstArr.length && secondIndex < secondArr.length) {
			if (firstArr[firstIndex] < secondArr[secondIndex]) {
				finalArray[index] = firstArr[firstIndex++];
			} else {
				finalArray[index] = secondArr[secondIndex++];
			}
			index++;
		}

		while (firstIndex < firstArr.length) {
			finalArray[index++] = firstArr[firstIndex++];
		}

		while (secondIndex < secondArr.length) {
			finalArray[index++] = secondArr[secondIndex++];
		}

	}

}
