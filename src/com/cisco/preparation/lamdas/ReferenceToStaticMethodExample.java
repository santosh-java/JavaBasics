package com.cisco.preparation.lamdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ReferenceToStaticMethodExample {
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16);
		List<Integer> primeNumbers = ReferenceToStaticMethodExample.findPrimeNumbers(numbers,
				ReferenceToStaticMethodExample::isPrime);

		System.out.println("Prime Numbers are " + primeNumbers);
	}

	public static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime(int number, int number2) {
		if (number == 1) {
			return false;
		}
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static List<Integer> findPrimeNumbers(List<Integer> list, Predicate<Integer> predicate) {
		List<Integer> sortedNumbers = new ArrayList<>();
		list.stream().filter(predicate::test).forEach(sortedNumbers::add);
		return sortedNumbers;

	}
}