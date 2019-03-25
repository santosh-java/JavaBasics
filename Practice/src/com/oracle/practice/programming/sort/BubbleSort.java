package com.oracle.practice.programming.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] arr = new int[] { 4, 5, 6, 2, 1, 7, 10, 3, 8, 9 };
		bs.bubbleSort(arr);
		System.out.println("Finally sorted array using Bubble sort ::");
		Arrays.stream(arr).forEach(System.out::print);

	}

	public void bubbleSort(int[] arr) {
		int loopcount = 0;
		
		for(int i=0; i< arr.length; i++) {
			boolean swapped = false;
			for(int j=0; j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					//Swap the two elements
					arr[j] = arr[j] + arr[j+1];
					arr[j+1] = arr[j]-arr[j+1];
					arr[j] = arr[j]-arr[j+1];
					swapped = true;
					System.out.print("Array after " + ++loopcount +"th iteration::" );
					Arrays.stream(arr).forEach(System.out::print);
					System.out.println("\n");
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
}
