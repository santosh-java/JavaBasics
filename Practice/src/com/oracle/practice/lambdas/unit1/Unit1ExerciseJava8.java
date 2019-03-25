package com.oracle.practice.lambdas.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Unit1ExerciseJava8 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		// step 1: sort list by first name
		System.out.println("Before sort Using printConditionally");
		printConditionally(people, p -> true);

		Collections.sort(people, (o1,o2) -> o1.getfName().compareTo(o2.getfName()));

		// step 2: Create a method that prints all elements in the list
		System.out.println("After sort Using printConditionally");
		printConditionally(people, p -> true);

		// step 3: Create a method that prints all people that have last name begginning
		// with C
		printConditionally(people, p -> p.getlName().startsWith("C"));

	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}
}