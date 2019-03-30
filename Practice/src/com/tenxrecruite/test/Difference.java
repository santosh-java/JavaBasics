package com.tenxrecruite.test;

import java.util.Scanner;

/**
 * Class that finds the difference between two numbers (0 to 10^15)
 * 
 * Each line of the input consists of a pair of integers. Each integer is
 * between 0 and 1015 (inclusive). The input is terminated by end of file.
 * 
 * @author smarthi
 *
 */
public class Difference {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			while (s.hasNextLine()) {
				String input = s.nextLine();
				if (input == null || input.length() == 0) {
					break;
				}
				String[] nums = input.split(" ");

				System.out.println(Math.abs(Long.valueOf(nums[0]) - Long.valueOf(nums[1])));
			}
		}
	}

}
