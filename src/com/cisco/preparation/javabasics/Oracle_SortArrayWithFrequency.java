package com.cisco.preparation.javabasics;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Oracle_SortArrayWithFrequency {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12, 1, 45, 1, 4, 3 };
		printArr(sortByFrequency(arr));
	}

	private static void printArr(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("]");
	}

	private static int[] sortByFrequency(int[] arr) {
		Map<Integer, Integer> countMap = new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			Integer count = countMap.get(arr[i]);
			if (count != null) {
				count++;
				countMap.put(arr[i], count);
			} else {
				countMap.put(arr[i], 1);
			}
		}

		Set<Integer> keySet = countMap.keySet();
		int i = 0;
		for (Integer key : keySet) {
			Integer count = countMap.get(key);
			while (count > 0) {
				arr[i++] = key;
				count--;
			}
		}

		return arr;
	}
}
