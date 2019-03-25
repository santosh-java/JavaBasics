package com.oracle.practice.lambdas.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
		int key = 0;

		process(nums, key, exceptionHandler((i, j) -> System.out.println(i / j)));
	}

	private static void process(int[] nums, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : nums) {
			consumer.accept(i, key);
		}
	}

	private static BiConsumer<Integer, Integer> exceptionHandler(BiConsumer<Integer, Integer> consumer) {
		return (i, j) -> {
			try {
				consumer.accept(i, j);
			}catch(ArithmeticException ae) {
				System.out.println("Exception");
			}
		};
	}

}
